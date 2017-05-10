package com.ift.web.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chen3 on 5/9/17.
 */

@RestController
@RequestMapping(value = "/api")
public class ApiController {


    /**
     * Accept data form external source
     * Data format: json
     */
    @RequestMapping(value = "/feedSatelliteData", method = RequestMethod.POST)
    public void SatelliteData(){

    }
}
