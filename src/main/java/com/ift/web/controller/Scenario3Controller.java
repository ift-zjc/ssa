package com.ift.web.controller;

import com.ift.domain.Satellite;
import com.ift.services.SatelliteService;
import com.ift.web.forms.SatelliteControlForm;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class Scenario3Controller {
    private static final Logger LOGGER = Logger.getLogger(PortalController.class.getName());

    @Autowired
    SatelliteService satelliteService;

    @GetMapping(value = "/scenario3")
    public String showPortal(Model model){
        SatelliteControlForm satelliteControlForm = new SatelliteControlForm();
        satelliteControlForm.setSatelliteList(satelliteService.listSatellites());
        model.addAttribute("satellite", satelliteControlForm);
        LOGGER.info("Start Portal Web Request");
        return "Scenario3";
    }


    /**
     * Model attributes
     */

    /**
     * Satelites list
     * @return
     */
    @ModelAttribute("allSatellites")
    public List<Satellite> modelSatellites(){
        return satelliteService.listSatellites();
    }
}
