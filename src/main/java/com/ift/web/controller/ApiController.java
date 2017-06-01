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
        jsonObject.addProperty("id", satelliteId);
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

        String jsonStr = (new Gson()).toJson(jsonObject);

        /**
         * Write to websocket channel: /topic/statllite/data
         */
        webSocket.convertAndSend("/topic/satellite/matedata", jsonStr);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }


    /**
     * Receiving Satellite data
     * @param cartesianData
     * @param completeFlag
     * @return
     */
    @PostMapping(value = "/feedSatelliteData")
    public @ResponseBody ResponseEntity<?> SatelliteData(@RequestParam("satelliteId") String satelliteId,
                                                         @RequestParam("cartesianData") List<Double> cartesianData,
                                                         @RequestParam("completeFlag") boolean completeFlag){

        LOGGER.info("Receiving satellite data");

        // Creating Json object.
        JsonObject jsonObject = new JsonObject();
        JsonArray cartesianDataArray = new JsonArray();
        // Fill data array
        for (double cartesianElement:cartesianData
             ) {
            JsonPrimitive cartesianNode = new JsonPrimitive(cartesianElement);
            cartesianDataArray.add(cartesianNode);
        }
        jsonObject.addProperty("satelliteId", satelliteId);
        jsonObject.add("satelliteData", cartesianDataArray);
        jsonObject.addProperty("completed", completeFlag);


        String jsonStr = (new Gson()).toJson(jsonObject);

        /**
         * Write to websocket channel: /topic/satellite/satellitedata
         */
        webSocket.convertAndSend("/topic/satellite/satellitedata", jsonStr);
        return new ResponseEntity<>(null, HttpStatus.OK);
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
}
