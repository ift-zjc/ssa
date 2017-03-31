package com.ift.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ift.domain.czml.*;
import com.ift.services.SatelliteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen3 on 3/30/17.
 */

@RestController
public class CzmlDataController {

    private static final Logger LOGGER = Logger.getLogger(CzmlDataController.class.getName());

    @Autowired
    SatelliteService satelliteService;

    @PostMapping(value = "/satelliteDataRequest", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String satelliteDataRequest(Model model){

        List<CzmlObj> czmlObjs = new ArrayList<CzmlObj>();
        // First element must with id = document
        CzmlObj czmlObj = new CzmlObj();
        czmlObj.setId("document");
        czmlObj.setName("IFT Satellites Monitoring");
        czmlObj.setVersion("1.0");
        Clock clock = new Clock();
        clock.setInterval("2016-03-15T10:00:00Z/2016-03-22T10:00:00Z");
        clock.setCurrentTime("2016-03-20T10:00:00Z");
        clock.setMultiplier(30);
        clock.setRange("LOOP_STOP");
        clock.setStep("SYSTEM_CLOCK_MULTIPLIER");
        czmlObj.setClock(clock);

        czmlObjs.add(czmlObj);

        czmlObj = new CzmlObj();
        czmlObj.setId("test satellite");
        czmlObj.setName("Test Satellite");
        czmlObj.setDescription("Click me");
        czmlObj.setAvailability("2016-03-15T10:00:00Z/2016-03-20T10:00:00Z");
        Billboard billboard = new Billboard();
        billboard.setImage("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAADJSURBVDhPnZHRDcMgEEMZjVEYpaNklIzSEfLfD4qNnXAJSFWfhO7w2Zc0Tf9QG2rXrEzSUeZLOGm47WoH95x3Hl3jEgilvDgsOQUTqsNl68ezEwn1vae6lceSEEYvvWNT/Rxc4CXQNGadho1NXoJ+9iaqc2xi2xbt23PJCDIB6TQjOC6Bho/sDy3fBQT8PrVhibU7yBFcEPaRxOoeTwbwByCOYf9VGp1BYI1BA+EeHhmfzKbBoJEQwn1yzUZtyspIQUha85MpkNIXB7GizqDEECsAAAAASUVORK5CYII=");
        billboard.setScale(1.5d);
        billboard.setShow(true);
        czmlObj.setBillboard(billboard);

        Position position = new Position();
        position.setInterpolationAlgorithm("LAGRANGE");
        position.setInterpolationDegree(5);
        position.setReferenceFrame("INERTIAL");
        position.setEpoch("2016-03-15T11:00:00Z");
        ArrayList<Double> positionList = new ArrayList<Double>();
        positionList.add(0d);
        positionList.add(4650397.56551457);
        positionList.add(-3390535.52275848);
        positionList.add(-4087729.48877329);
        positionList.add(1000d);
        positionList.add(-6000251.41586053);
        positionList.add(3168038.65147806);
        positionList.add(-1983402.41619314);
        positionList.add(2000d);
        positionList.add(4301545.02457765);
        positionList.add(-1619032.41301719);
        positionList.add(5340730.82941359);
        position.setCartesian(positionList);
        czmlObj.setPosition(position);
        PathShow pathShow = new PathShow();
        pathShow.setDisplay(true);
        pathShow.setInterval("2016-03-15T10:00:00Z/2016-03-20T10:00:00Z");
        Path path = new Path();
        path.setResolution(120);
        path.setPathShow(pathShow);
        czmlObj.setPath(path);

        czmlObjs.add(czmlObj);

        String jsonStr = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            jsonStr= mapper.writeValueAsString(czmlObjs);
        }catch(Exception ex){
            LOGGER.error(ex);
        }
        return jsonStr;

    }

}
