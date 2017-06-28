package com.ift.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import com.ift.domain.czml.*;
import com.ift.services.StorageService;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.EigenDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by chen3 on 5/9/17.
 */

@RestController
@RequestMapping(value = "/api")
public class ApiController {

    private static final Logger LOGGER = Logger.getLogger(ApiController.class.getName());

    @Autowired
    private SimpMessagingTemplate webSocket;
    @Autowired
    private StorageService storageService;


    @PostMapping(value = "/startSatelliteData")
    public @ResponseBody ResponseEntity<?> StartSatelliteData(@RequestParam("uuid") String uuid){

        LOGGER.info("Start new Satellite data file");


        // Document data.
        JsonObject documentJsonObj = new JsonObject();
        documentJsonObj.addProperty("id", "document");
        documentJsonObj.addProperty("version", "1.0");
        JsonObject documentJsonObjClock = new JsonObject();
        documentJsonObjClock.addProperty("currentTime", "2012-03-15T10:00:00Z");
        documentJsonObjClock.addProperty("interval", "2012-03-15T10:00:00Z/2012-03-16T10:00:00Z");
        documentJsonObjClock.addProperty("multiple", 60);
        documentJsonObjClock.addProperty("range", "LOOP_STOP");
        documentJsonObjClock.addProperty("step", "SYSTEM_CLOCK_MULTIPLIER");
        documentJsonObj.add("clock", documentJsonObjClock);

        JsonArray documentJsonArray = new JsonArray();
        documentJsonArray.add(documentJsonObj);

        String jsonStr = (new Gson()).toJson(documentJsonArray);

        // Create new file under data folder
        // Load file
        Path czmlFilePath = storageService.load("czml-"+uuid);
        try {
            Files.write(czmlFilePath, jsonStr.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    /**
     * Accept data form external source
     * Data format: json
     */
    @PostMapping(value = "/feedSatelliteMateData")
    public @ResponseBody ResponseEntity<?> SatelliteMateData(@RequestParam("satelliteId") String satelliteId,
                                                             @RequestParam("satelliteName") String satelliteName,
                                                             @RequestParam("satelliteDesc") String satelliteDesc,
                                                             @RequestParam("satelliteAvailability") String satelliteAvailability,
                                                             @RequestParam("satelliteEpoch") String satelliteEpoch,
                                                             @RequestParam("uuid") String uuid){

        LOGGER.info("New satellite meta data received");

        // Get 100 object for each satellite
        JsonArray satelliteArray = new JsonArray();

        for(int i = 0; i<101; i++) {

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id", i==0 ? satelliteId : satelliteId+"_"+i);
            jsonObject.addProperty("name", satelliteName);
            jsonObject.addProperty("availability", satelliteAvailability);
            jsonObject.addProperty("description", satelliteDesc);

            JsonObject positionJsonObject = new JsonObject();
            positionJsonObject.addProperty("interpolationAlgorithm", "LAGRANGE");
            positionJsonObject.addProperty("interpolationDegree", 5);
            positionJsonObject.addProperty("referenceFrame", "INERTIAL");
            positionJsonObject.addProperty("epoch", satelliteEpoch);
            positionJsonObject.add("cartesian", new JsonArray());

            JsonObject billboardJsonObject = new JsonObject();
            billboardJsonObject.addProperty("horizontalOrigin", "CENTER");
            billboardJsonObject.addProperty("image", "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAADJSURBVDhPnZHRDcMgEEMZjVEYpaNklIzSEfLfD4qNnXAJSFWfhO7w2Zc0Tf9QG2rXrEzSUeZLOGm47WoH95x3Hl3jEgilvDgsOQUTqsNl68ezEwn1vae6lceSEEYvvWNT/Rxc4CXQNGadho1NXoJ+9iaqc2xi2xbt23PJCDIB6TQjOC6Bho/sDy3fBQT8PrVhibU7yBFcEPaRxOoeTwbwByCOYf9VGp1BYI1BA+EeHhmfzKbBoJEQwn1yzUZtyspIQUha85MpkNIXB7GizqDEECsAAAAASUVORK5CYII=");


            jsonObject.add("billboard", billboardJsonObject);
            jsonObject.add("position", positionJsonObject);

            satelliteArray.add(jsonObject);
        }




        // Combine
        JsonArray documentArray = new JsonArray();
        documentArray.addAll(satelliteArray);

        // Get JSONObject form file based on UUID
        JsonArray savedJsonObject = null;
        try {
            savedJsonObject = this.getJsonFromFile(uuid);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Add current data to JSON object root.
        savedJsonObject.addAll(satelliteArray);

        String jsonStr = (new Gson()).toJson(savedJsonObject);

        // Load file
        Path czmlFilePath = storageService.load("czml-"+uuid);
        // Write to file
        try {
            Files.write(czmlFilePath, jsonStr.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * Write to websocket channel: /topic/statllite/data
         */
//        webSocket.convertAndSend("/topic/satellite/matedata", jsonStr);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }


    /**
     * Relational data
     * @param obj1
     * @param obj2
     * @param name
     * @param availability
     * @param desc
     * @return
     */
    @PostMapping(value = "/feedRelationData")
    public @ResponseBody ResponseEntity<?> RelationalData(@RequestParam("object1Id") String obj1,
                                                          @RequestParam("object2Id") String obj2,
                                                          @RequestParam("name") String name,
                                                          @RequestParam("availability") String availability,
                                                          @RequestParam("desc") String desc,
                                                          @RequestParam("uuid") String uuid){
        LOGGER.info("New relationship data received");

        // Get data
        try {
            String jsonString = new String(Files.readAllBytes(storageService.load("czml-"+uuid)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", obj1+"/"+obj2);
        jsonObject.addProperty("name", name);
        jsonObject.addProperty("description", desc);
        jsonObject.addProperty("availability", availability);

        JsonObject polyLineObj = new JsonObject();
        polyLineObj.addProperty("width", 1);
        polyLineObj.addProperty("followSurface", false);

        // Show
        JsonArray showObject = new JsonArray();
        JsonObject showIntervalObject = new JsonObject();
        showIntervalObject.addProperty("interval", availability);
        showIntervalObject.addProperty("boolean", true);

        showObject.add(showIntervalObject);
        polyLineObj.add("show", showObject);

        // Material
//        JsonObject materialObj = new JsonObject();
//
////        materialObj.add("solidColor", )
//        JsonArray rgbaArray = computeJsonArray(0, 255,255,255);
//        JsonObject colorObj = new JsonObject();
//        colorObj.add("rgba", rgbaArray);
//        JsonObject solidColorObj = new JsonObject();
//        solidColorObj.add("color", solidColorObj);
//        materialObj.add("solidColor", solidColorObj);
//
//        polyLineObj.add("material", materialObj);

        // Positions
        JsonObject positionsObj = new JsonObject();
        JsonArray referencesObj = new JsonArray();
        referencesObj.add(new JsonPrimitive(obj1+"#position"));
        referencesObj.add(new JsonPrimitive(obj2+"#position"));
        positionsObj.add("references", referencesObj);

        polyLineObj.add("positions", positionsObj);



        jsonObject.add("polyline", polyLineObj);
        String jsonStr = (new Gson()).toJson(jsonObject);

        /**
         * Write to websocket channel: /topic/statllite/data
         */
        webSocket.convertAndSend("/topic/satellite/relatedata", jsonStr);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }


    /**
     * Receiving Satellite data
     * @param cartesianData
     * @return
     */
    @PostMapping(value = "/feedSatelliteData")
    public @ResponseBody ResponseEntity<?> SatelliteData(@RequestParam("satelliteId") String satelliteId,
                                                         @RequestParam("cartesianData") List<Double> cartesianData,
                                                         @RequestParam("p") List<Double> pMatrix,
                                                         @RequestParam("uuid") String uuid ){

        LOGGER.info("Receiving satellite data");

        // Get JsonObject from file
        JsonArray savedJsonObject = null;
        try {
            savedJsonObject = this.getJsonFromFile(uuid);
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Get Q from P
        RealMatrix matrix = new Array2DRowRealMatrix(new double[3][3]);
        matrix.setEntry(0,0,150.04);
        matrix.setEntry(0,1,1.3293);
        matrix.setEntry(0,2,0.8439);

        matrix.setEntry(1,0, 1.3293);
        matrix.setEntry(1,1,124.36);
        matrix.setEntry(1,2,0.6936);

        matrix.setEntry(2, 0, 0.8439);
        matrix.setEntry(2,1,0.6936);
        matrix.setEntry(2,2, 129.35);

//        int index = 0;
//        RealMatrix matrix = new Array2DRowRealMatrix(new double[3][3]);
//        for(int i = 0; i<3; i++){
//            for(int j=0; j<3; j++){
//                matrix.setEntry(i,j,pMatrix.get(index++));
//            }
//        }
        EigenDecomposition eigenDecomposition = new EigenDecomposition(matrix);
        RealMatrix sqrtMatrix = eigenDecomposition.getSquareRoot();


        // Get Gaussian
        RealMatrix gaussianMatrix = new Array2DRowRealMatrix(new  double[3]);
        Random random = new Random();

        // Creating Json object.
        JsonArray cartesianDataArray = new JsonArray();

        // Size must be 4 even, (but matlab not always return 4x data)
        int dataSize = cartesianData.size() % 4;
        // Fill data array
        for (int n = 0; n<cartesianData.size()-dataSize; n++) {
            JsonPrimitive cartesianNode = new JsonPrimitive(cartesianData.get(n));
            cartesianDataArray.add(cartesianNode);
        }

        // Loop the json array
        for (JsonElement satelliteNode: savedJsonObject
             ) {
            JsonObject jsonObjectNode = satelliteNode.getAsJsonObject();

            // Add to original data
            if(jsonObjectNode.get("id").getAsString().equals(satelliteId)){
                // Add original data.
                jsonObjectNode.get("position").getAsJsonObject().get("cartesian").getAsJsonArray().addAll(cartesianDataArray);
            }

            JsonArray randomJsonArray = new JsonArray();
            RealMatrix cartesianMatrix = new Array2DRowRealMatrix(new double [3][0]);

            // Check for random number
            if(jsonObjectNode.get("id").getAsString().startsWith(satelliteId+"_")){
                // Add random data

                // Get point
                for(int aa = 0; aa<cartesianDataArray.size(); aa+=4){
                    cartesianMatrix.setEntry(0,0,cartesianDataArray.get(aa+1).getAsDouble());
                    cartesianMatrix.setEntry(1,0,cartesianDataArray.get(aa+2).getAsDouble());
                    cartesianMatrix.setEntry(2,0,cartesianDataArray.get(aa+3).getAsDouble());

                    for(int k = 0; k < 3; k++){
                        gaussianMatrix.setEntry(k, 0, random.nextGaussian());
                    }

                    // Calculate
                    RealMatrix matrixMultiple = sqrtMatrix.multiply(gaussianMatrix);
                    // Calculate random x,y,z
                    RealMatrix matrixRandom = cartesianMatrix.add(matrixMultiple);

                    // Add to json
                    randomJsonArray.add(cartesianDataArray.get(aa));
                    randomJsonArray.add(new JsonPrimitive(matrixRandom.getEntry(0,0)));
                    randomJsonArray.add(new JsonPrimitive(matrixRandom.getEntry(1,0)));
                    randomJsonArray.add(new JsonPrimitive(matrixRandom.getEntry(2,0)));

                    jsonObjectNode.get("position").getAsJsonObject().get("cartesian").getAsJsonArray().addAll(randomJsonArray);
                }
            }
        }



        String jsonStr = (new Gson()).toJson(savedJsonObject);

        // Load file
        Path czmlFilePath = storageService.load("czml-"+uuid);
        // Write to file
        try {
            Files.write(czmlFilePath, jsonStr.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    /**
     * Data transferring completed
     * @param completeFlag
     * @return
     */
    @PostMapping(value = "/feedCompleteFlagData")
    public @ResponseBody ResponseEntity<?> CompleteFlag(@RequestParam("completeFlag") boolean completeFlag,
                                                        @RequestParam("uuid") String uuid){

        LOGGER.info("Received complete flag, ready to redraw");

        // Creating Json object.
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("completed", completeFlag);

        String jsonStr = (new Gson()).toJson(jsonObject);

        /**
         * Write to websocket channel: /topic/satellite/datacompleted
         */
        webSocket.convertAndSend("/topic/satellite/datacompleted", jsonStr);
        return new ResponseEntity<Object>(null, HttpStatus.MULTI_STATUS.OK);
    }

    /**
     * Position list fillup
     * @param data
     * @return
     */
    private ArrayList<Double> fillPosition( Double... data){
        ArrayList<Double> positionList = new ArrayList<Double>();
        for (double item: data) {
            positionList.add(item);
        }

        return positionList;
    }

    /**
     * Format Integer json Array
     * @param data
     * @return
     */
    private JsonArray computeJsonArray(Integer... data){
        JsonArray jsonArray = new JsonArray();
        for (int element : data
             ) {
            jsonArray.add(new JsonPrimitive(element));
        }

        return jsonArray;
    }

    /**
     * Parse file to JSONObject
     * @param uuid
     * @return JsonObject
     * @throws IOException
     */
    private JsonArray getJsonFromFile(String uuid) throws IOException {
        String content = new String(Files.readAllBytes(storageService.load("czml-"+uuid)));
        // Convert context to JSONObject
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        JsonArray jsonArray = gson.fromJson(content, JsonArray.class);

        return jsonArray;
    }
}
