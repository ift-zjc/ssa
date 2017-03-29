package com.ift.bootstrap;

import com.ift.domain.Satellite;
import com.ift.services.SatelliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by zhijiangchen on 3/28/17.
 */

@Component
public class SatelliteLoader implements ApplicationListener<ContextRefreshedEvent> {

    SatelliteService satelliteService;

    @Autowired
    void setSatelliteService(SatelliteService satelliteService){this.satelliteService = satelliteService;}

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        Satellite satellite = new Satellite();
        satellite.setName("Satellite 1");
        satelliteService.saveSatellite(satellite);

    }
}
