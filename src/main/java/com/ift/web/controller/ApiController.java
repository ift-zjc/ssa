package com.ift.web.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import com.ift.domain.*;
import com.ift.domain.czml.*;
import com.ift.requestobj.SatelliteDto;
import com.ift.services.*;
import javafx.concurrent.Task;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by chen3 on 5/9/17.
 */

@RestController
@RequestMapping(value = "/api")
public class
ApiController {

    private static final Logger LOGGER = Logger.getLogger(ApiController.class.getName());

    private final String DATA_TYPE_ALL = "A";
    private final String DATA_TYPE_OPTIMIZED = "O";

    @Autowired
    private SimpMessagingTemplate webSocket;
    @Autowired
    private SatelliteService satelliteService;
    @Autowired
    private BaseStationService baseStationService;
    @Autowired
    private MatelabSatelliteService matelabSatelliteService;
    @Autowired
    private MonitorSoInfoService monitorSoInfoService;
    @Autowired
    private TimeLineService timeLineService;
    @Autowired
    private SmSoInfoAllService smSoInfoAllService;
    @Autowired
    private StatusService statusService;
    @Autowired
    private CollisionService collisionService;


    /**
     * Accept cesium mate data
     * @param startTime
     * @param endTime
     * @return
     */
    @PostMapping(value = "/feedCesiumMateData")
    public @ResponseBody ResponseEntity<?> CesiumMateData(@RequestParam("startTime") String startTime,
                                                          @RequestParam("stopTime") String endTime){

        LOGGER.info("Receive cesium mate data");

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("startTime", startTime);
        jsonObject.addProperty("endTime", endTime);

        String jsonStr = (new Gson()).toJson(jsonObject);

        /**
         * Write to websocket channel: /topic/statllite/data
         */
        webSocket.convertAndSend("/topic/satellite/cesiumMateData", jsonStr);

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


    @PostMapping(value = "/feedCollisionData")
    public ResponseEntity<?> CollisionData(@RequestParam("sid1") String sid1,
                                                         @RequestParam("sid2") String sid2,
                                                         @RequestParam("timeData") String timeData,
                                                         @RequestParam("collisionData") String collisionData){

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("sid1", sid1);
        jsonObject.addProperty("sid2", sid2);

        String[] timeDataArray = timeData.split(",");
        String[] collisionDataArray = collisionData.split(",");

        JsonArray timeDataJsonArray = new JsonArray();
        for(String tData : timeDataArray){
            JsonPrimitive td = new JsonPrimitive(tData);
            timeDataJsonArray.add(td);
        }

        JsonArray collisionDataJsonArray = new JsonArray();
        for(String cData : collisionDataArray){
            JsonPrimitive cd = new JsonPrimitive(cData);
            collisionDataJsonArray.add(cd);
        }

        jsonObject.add("timeData", timeDataJsonArray);
        jsonObject.add("collisionData", collisionDataJsonArray);

        String jsonStr = (new Gson()).toJson(jsonObject);

        /**
         * Write to websocket channel: /topic/statllite/collisiondata
         */
        webSocket.convertAndSend("/topic/satellite/collisiondata", jsonStr);
        return new ResponseEntity<>(null, HttpStatus.OK);

    }


    /**
     * Ground station data
     * @param gsJsonData
     * @return
     */
    @PostMapping(value = "/feedGroundStationData")
    public @ResponseBody ResponseEntity<?> GroundStationData(@RequestParam("gsId") String gsId,
                                                             @RequestParam("gsData") List<Double> gsJsonData){

        JsonObject jsonObject = new JsonObject();

        JsonArray gsDataArray = new JsonArray();
        // Fill data array
        for (double gsElement:gsJsonData
                ) {
            JsonPrimitive cartesianNode = new JsonPrimitive(gsElement);
            gsDataArray.add(cartesianNode);
        }

        jsonObject.addProperty("gsId", gsId);
        jsonObject.add("gsData", gsDataArray);

        String gsJsonStr = (new Gson()).toJson(jsonObject);

        webSocket.convertAndSend("/topic/satellite/groundstations", gsJsonStr);
        return new ResponseEntity<Object>(null, HttpStatus.OK);
    }


    /**
     * related data
     * @param sId
     * @param gsId
     * @param availability
     * @return
     */
    @PostMapping(value = "/feedRelationData")
    public @ResponseBody ResponseEntity<?> RelationalData(@RequestParam("satelliteId") String sId,
                                                          @RequestParam("gsId") String gsId,
                                                          @RequestParam("availability") List<String> availability,
                                                          @RequestParam("datatype") String dType){
        LOGGER.info("New relationship data received");

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("satelliteId", sId);
        jsonObject.addProperty("gsId", gsId);

        JsonArray availabilityArray = new JsonArray();

        for(String timeDataElement:availability){
            JsonPrimitive timeDataNode = new JsonPrimitive(timeDataElement);
            availabilityArray.add(timeDataNode);
        }

        jsonObject.add("availability", availabilityArray);
        jsonObject.add("datatype", new JsonPrimitive(dType));

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
                                                         @RequestParam("timeData") List<String> timeData,
                                                         @RequestParam("p") List<Double> uncertaintyData
                                                         /*@RequestParam("completeFlag") boolean completeFlag*/){

        LOGGER.info("Receiving satellite data");

        // Creating Json object.
        JsonObject jsonObject = new JsonObject();
        JsonArray cartesianDataArray = new JsonArray();
        JsonArray predefinededDataArray = new JsonArray();
        JsonArray timeDataArray = new JsonArray();
        JsonArray uncertaintyArray = new JsonArray();
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
        for(double uncertaintyElement : uncertaintyData){
            JsonPrimitive uncertaintyNode = new JsonPrimitive(uncertaintyElement);
            uncertaintyArray.add(uncertaintyNode);
        }
        jsonObject.addProperty("satelliteId", satelliteId);
        jsonObject.addProperty("satelliteName", satelliteName);
        jsonObject.addProperty("satelliteDesc", satelliteDesc);
        jsonObject.addProperty("satelliteAvailability", satelliteAvailability);
        jsonObject.addProperty("satelliteEpoch", satelliteEpoch);
        jsonObject.add("satelliteData", cartesianDataArray);
        jsonObject.add("predefindedData", predefinededDataArray);
        jsonObject.add("timeData", timeDataArray);
        jsonObject.add("uncertainty", uncertaintyArray);

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


    @PostMapping(value = "/feedPredefindedSatelliteData")
    public void LoadPredefindedData(){
        LOGGER.info("Start load pre-definded data");

        // Get data from database.
        List<Satellite> satellites = satelliteService.listSatellites();
        List<SatelliteDto> satelliteDtos = satellites.stream().map(
                satellite -> {
                    SatelliteDto satelliteDto = new SatelliteDto();
                    return satelliteDto;
                }
        ).collect(Collectors.toList());

        for(Satellite satellite : satellites) {
            loadSatelliteData(satellite);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        // Load base station data
        List<BaseStation> baseStationList = baseStationService.listBaseStation();
        // Load to front end.
        baseStationList.forEach(baseStation -> {
            loadGroundStationData(baseStation);
        });

        // Load matlab timeline data
        List<TimeLine> timeLineList = timeLineService.listTimeLine();
        // Load to front end.
        timeLineList.forEach(timeLine -> {
            loadTimeLineData(timeLine);
        });

        // Load matlab satellite data
        List<MatlabSatellite> matlabSatelliteList = matelabSatelliteService.listMatlabSatellites();
        //load to front end
        matlabSatelliteList.forEach(matlabSatellite -> {
            loadSatelliteData(matlabSatellite);
        });

        // Load related data
        List<SmSoInfoAll> smSoInfoAllList = smSoInfoAllService.listStatus();
        //load to front end
        smSoInfoAllList.forEach(smSoInfoAll -> {
            loadRelatedData(smSoInfoAll);
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Load collision data
        List<Collision> collisionList = collisionService.ListCollision();
        //load to front end
        collisionList.forEach(collision -> {
            loadCollissionData(collision);
        });

//        return new ResponseEntity<>(null, HttpStatus.OK);
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
     * Load satellite data.
     * @param satellite
     */
    private void loadSatelliteData(Satellite satellite){
        // Creating Json object.
        JsonObject jsonObject = new JsonObject();
        JsonArray cartesianDataArray = new JsonArray();
        JsonArray timeDataArray = new JsonArray();

        // Fill data array

        for(SatellitePosition satellitePosition : satellite.getSatellitePositions()) {
            JsonPrimitive cartesianNode = new JsonPrimitive(satellitePosition.getX());
            cartesianDataArray.add(cartesianNode);
            cartesianNode = new JsonPrimitive(satellitePosition.getY());
            cartesianDataArray.add(cartesianNode);
            cartesianNode = new JsonPrimitive(satellitePosition.getZ());
            cartesianDataArray.add(cartesianNode);

            JsonPrimitive timeDataNode = new JsonPrimitive(satellitePosition.getTime());
            timeDataArray.add(timeDataNode);
        }

        jsonObject.addProperty("satelliteId", satellite.getId());
        jsonObject.addProperty("satelliteName", satellite.getName());
        jsonObject.addProperty("satelliteDesc", "");
//            jsonObject.addProperty("satelliteAvailability", satelliteAvailability);
//            jsonObject.addProperty("satelliteEpoch", satelliteEpoch);
        jsonObject.add("satelliteData", cartesianDataArray);
        jsonObject.add("timeData", timeDataArray);

        // Move to seperated API
//        jsonObject.addProperty("completed", completeFlag);


        String jsonStr = (new Gson()).toJson(jsonObject);

        /**
         * Write to websocket channel: /topic/satellite/satellitedata
         */
        webSocket.convertAndSend("/topic/satellite/preloadeddata", jsonStr);
    }

    /**
     * Load basestation to cesium
     * @param baseStation
     */
    private void loadGroundStationData(BaseStation baseStation){
        JsonObject jsonObject = new JsonObject();

        JsonArray gsDataArray = new JsonArray();
        // Fill data array

        JsonPrimitive cartesianNode = new JsonPrimitive(baseStation.getX());
        gsDataArray.add(cartesianNode);
        cartesianNode = new JsonPrimitive(baseStation.getY());
        gsDataArray.add(cartesianNode);
        cartesianNode = new JsonPrimitive(baseStation.getZ());
        gsDataArray.add(cartesianNode);


        jsonObject.addProperty("gsId", baseStation.getBsid());
        jsonObject.add("gsData", gsDataArray);

        String gsJsonStr = (new Gson()).toJson(jsonObject);

        webSocket.convertAndSend("/topic/satellite/groundstations", gsJsonStr);
    }

    /**
     * Load basestation to cesium
     * @param timeLine
     */
    private void loadTimeLineData(TimeLine timeLine){
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("startTime", timeLine.getStartTime());
        jsonObject.addProperty("endTime", timeLine.getEndTime());
        String tlJsonStr = (new Gson().toJson(jsonObject));

        webSocket.convertAndSend("/topic/satellite/cesiumMateData", tlJsonStr);
    }

    /**
     * Load basestation to cesium
     * @param matlabSatellite
     */
    private void loadSatelliteData(MatlabSatellite matlabSatellite){
        JsonObject jsonObject = new JsonObject();
        JsonArray cartesianDataArray = new JsonArray();
        JsonArray predefinededDataArray = new JsonArray();
        JsonArray timeDataArray = new JsonArray();
        JsonArray uncertaintyArray = new JsonArray();


        jsonObject.addProperty("satelliteId", matlabSatellite.getSatelliteId());
        jsonObject.addProperty("satelliteName", matlabSatellite.getName());
        jsonObject.addProperty("satelliteDesc", "satellite monitoring");
        jsonObject.addProperty("satelliteAvailability", "2012-03-15T10:00:00Z/2012-03-16T02:40:00Z");
        jsonObject.addProperty("satelliteEpoch", "2012-03-15T10:00:00Z");


        matlabSatellite.getMonitorSoInfos().forEach(record -> {
            // Fill data array


            JsonPrimitive cartesianNode = new JsonPrimitive(record.getCartesianX());
            cartesianDataArray.add(cartesianNode);
            cartesianNode = new JsonPrimitive(record.getCartesianY());
            cartesianDataArray.add(cartesianNode);
            cartesianNode = new JsonPrimitive(record.getCartesianZ());
            cartesianDataArray.add(cartesianNode);

            JsonPrimitive predefinededNode = new JsonPrimitive(record.getPredefinedX());
            predefinededDataArray.add(predefinededNode);
            predefinededNode = new JsonPrimitive(record.getPredefinedY());
            predefinededDataArray.add(predefinededNode);
            predefinededNode = new JsonPrimitive(record.getPredefinedZ());
            predefinededDataArray.add(predefinededNode);

            JsonPrimitive timeNode = new JsonPrimitive(record.getTimestamp());
            timeDataArray.add(timeNode);

            JsonPrimitive uncertaintyNode = new JsonPrimitive(record.getP1());
            uncertaintyArray.add(uncertaintyNode);
            uncertaintyNode = new JsonPrimitive(record.getP2());
            uncertaintyArray.add(uncertaintyNode);
            uncertaintyNode = new JsonPrimitive(record.getP3());
            uncertaintyArray.add(uncertaintyNode);
            uncertaintyNode = new JsonPrimitive(record.getP4());
            uncertaintyArray.add(uncertaintyNode);
            uncertaintyNode = new JsonPrimitive(record.getP5());
            uncertaintyArray.add(uncertaintyNode);
            uncertaintyNode = new JsonPrimitive(record.getP6());
            uncertaintyArray.add(uncertaintyNode);
            uncertaintyNode = new JsonPrimitive(record.getP7());
            uncertaintyArray.add(uncertaintyNode);
            uncertaintyNode = new JsonPrimitive(record.getP8());
            uncertaintyArray.add(uncertaintyNode);
            uncertaintyNode = new JsonPrimitive(record.getP9());
            uncertaintyArray.add(uncertaintyNode);
        });
        jsonObject.add("satelliteData", cartesianDataArray);
        jsonObject.add("predefindedData", predefinededDataArray);
        jsonObject.add("timeData", timeDataArray);
        jsonObject.add("uncertainty", uncertaintyArray);



        String moJsonStr = (new Gson()).toJson(jsonObject);

        webSocket.convertAndSend("/topic/satellite/satellitedata", moJsonStr);
    }

    /**
     * Load basestation to cesium
     * @param smSoInfoAll
     */
    private void loadRelatedData(SmSoInfoAll smSoInfoAll){
        JsonObject jsonObject = new JsonObject();
        JsonArray availabilityArray = new JsonArray();

        JsonPrimitive availabilityNode = new JsonPrimitive(smSoInfoAll.getStartTime()+"/"+smSoInfoAll.getEndTime());
        availabilityArray.add(availabilityNode);

        jsonObject.addProperty("satelliteId", smSoInfoAll.getMatlabSatellite().getSatelliteId());
        jsonObject.addProperty("gsId", smSoInfoAll.getBaseStation().getBsid());
        jsonObject.add("availability", availabilityArray);
        jsonObject.addProperty("datatype", smSoInfoAll.getDataType());

        String jsonStr = (new Gson().toJson(jsonObject));

        webSocket.convertAndSend("/topic/satellite/relatedata", jsonStr);
    }

    /**
     * Load basestation to cesium
     * @param collision
     */
    private void loadCollissionData(Collision collision){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("sid1", collision.getSatellite1().getId());
        jsonObject.addProperty("sid2", collision.getSatellite2().getId());

        JsonArray timeDataJsonArray = new JsonArray();
        JsonPrimitive timeDataNode = new JsonPrimitive(collision.getTime());
        jsonObject.add("timeData", timeDataJsonArray);

        JsonArray collisionDataJsonArray = new JsonArray();
        JsonPrimitive collisionDataNode = new JsonPrimitive(collision.getCollisionData());
        jsonObject.add("collisionData", collisionDataJsonArray);

        String jsonStr = (new Gson()).toJson(jsonObject);

        /**
         * Write to websocket channel: /topic/statllite/collisiondata
         */
        webSocket.convertAndSend("/topic/satellite/collisiondata", jsonStr);
    }



}
