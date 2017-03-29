package com.ift.web.controller;

import com.ift.domain.Satellite;
import com.ift.services.SatelliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by zhijiangchen on 3/24/17.
 */

@Controller
public class PortalController {

    @Autowired
    SatelliteService satelliteService;

    @RequestMapping(value = "/portal", method = RequestMethod.GET)
    public String showPortal(){
        List<Satellite> satelliteList = satelliteService.listSatellites();
        System.out.println("Satellite count: " + satelliteList.size());
        return "portal";
    }
}
