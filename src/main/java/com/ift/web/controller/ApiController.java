package com.ift.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import com.ift.domain.czml.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen3 on 5/9/17.
 */

@RestController
@RequestMapping(value = "/api")
public class ApiController {

    private static final Logger LOGGER = Logger.getLogger(ApiController.class.getName());

    @Autowired
    private SimpMessagingTemplate webSocket;

    /**
     * Accept data form external source
     * Data format: json
     */
    @PostMapping(value = "/feedSatelliteMateData")
    public @ResponseBody ResponseEntity<?> SatelliteMateData(@RequestParam("satelliteId") String satelliteId,
                                                             @RequestParam("satelliteName") String satelliteName,
                                                             @RequestParam("satelliteDesc") String satelliteDesc,
                                                             @RequestParam("satelliteAvailability") String satelliteAvailability,
                                                             @RequestParam("satelliteEpoch") String satelliteEpoch){

        LOGGER.info("New satellite meta data received");


        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("satelliteId", satelliteId);
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

        // Model jsonObject
        JsonObject modelJsonObject = new JsonObject();
        modelJsonObject.addProperty("silhouetteColor", "Color.Red");
        modelJsonObject.addProperty("silhouetteSize", 200);

        jsonObject.add("billboard", billboardJsonObject);
        jsonObject.add("position", positionJsonObject);
        jsonObject.add("model", modelJsonObject);

        String jsonStr = (new Gson()).toJson(jsonObject);

        /**
         * Write to websocket channel: /topic/statllite/data
         */
        webSocket.convertAndSend("/topic/satellite/matedata", jsonStr);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }


    /**
     * Ground station data
     * @param gsJsonData
     * @return
     */
    @PostMapping(value = "/feedGroundStationData")
    public @ResponseBody ResponseEntity<?> GroundStationData(@RequestParam("gsData") String gsJsonData){

        webSocket.convertAndSend("/topic/satellite/groundstations", gsJsonData);
        return new ResponseEntity<Object>(null, HttpStatus.OK);
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
                                                          @RequestParam("desc") String desc){
        LOGGER.info("New relationship data received");

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("satelliteId", obj1+"/"+obj2);
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
                                                         @RequestParam("satelliteName") String satelliteName,
                                                         @RequestParam("satelliteDesc") String satelliteDesc,
                                                         @RequestParam("satelliteAvailability") String satelliteAvailability,
                                                         @RequestParam("satelliteEpoch") String satelliteEpoch,
                                                         @RequestParam("cartesianData") List<Double> cartesianData,
                                                         @RequestParam("preDefindedData") List<Double> predefinedData,
                                                         @RequestParam("timeData") List<String> timeData
                                                         /*@RequestParam("completeFlag") boolean completeFlag*/){

        LOGGER.info("Receiving satellite data");

        // Creating Json object.
        JsonObject jsonObject = new JsonObject();
        JsonArray cartesianDataArray = new JsonArray();
        JsonArray predefinededDataArray = new JsonArray();
        JsonArray timeDataArray = new JsonArray();
        // Fill data array
        for (double cartesianElement:cartesianData
                ) {
            JsonPrimitive cartesianNode = new JsonPrimitive(cartesianElement);
            cartesianDataArray.add(cartesianNode);
        }
        for (double predefindedElemenet: predefinedData){
            JsonPrimitive predefindedNode = new JsonPrimitive(predefindedElemenet);
            predefinededDataArray.add(predefindedNode);
        }
        for(String timeDataElement:timeData){
            JsonPrimitive timeDataNode = new JsonPrimitive(timeDataElement);
            timeDataArray.add(timeDataNode);
        }
        jsonObject.addProperty("satelliteId", satelliteId);
        jsonObject.addProperty("satellitename", satelliteName);
        jsonObject.addProperty("satelliteDesc", satelliteDesc);
        jsonObject.addProperty("satelliteAvailability", satelliteAvailability);
        jsonObject.addProperty("satelliteEpoch", satelliteEpoch);
        jsonObject.add("satelliteData", cartesianDataArray);
        jsonObject.add("predefindedData", predefinededDataArray);
        jsonObject.add("timeData", timeDataArray);

        // Move to seperated API
//        jsonObject.addProperty("completed", completeFlag);


        String jsonStr = (new Gson()).toJson(jsonObject);

        /**
         * Write to websocket channel: /topic/satellite/satellitedata
         */
        webSocket.convertAndSend("/topic/satellite/satellitedata", jsonStr);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    /**
     * Data transferring completed
     * @param completeFlag
     * @return
     */
    @PostMapping(value = "/feedCompleteFlagData")
    public @ResponseBody ResponseEntity<?> CompleteFlag(@RequestParam("completeFlag") boolean completeFlag){

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
}
