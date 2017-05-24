package com.ift.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by chen3 on 5/9/17.
 */

@RestController
@RequestMapping(value = "/api")
public class ApiController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * Accept data form external source
     * Data format: json
     */
    @PostMapping(value = "/feedSatelliteData")
    public @ResponseBody ResponseEntity<?> SatelliteData(@RequestParam("satelliteData") String satelliteData){

        log.info(satelliteData);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
