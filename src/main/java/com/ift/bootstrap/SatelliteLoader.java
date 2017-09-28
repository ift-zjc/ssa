package com.ift.bootstrap;

import com.ift.common.Helper;
import com.ift.domain.Satellite;
import com.ift.domain.Status;
import com.ift.services.SatelliteService;
import com.ift.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by zhijiangchen on 3/28/17.
 */

@Component
public class SatelliteLoader implements ApplicationListener<ContextRefreshedEvent> {

    SatelliteService satelliteService;
    StatusService statusService;

    @Autowired
    void setSatelliteService(SatelliteService satelliteService) {
        this.satelliteService = satelliteService;
    }

    @Autowired
    void setStatusService(StatusService statusService) {
        this.statusService = statusService;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        Satellite satellite = new Satellite();
        satellite.setName("Satellite 1");
        satelliteService.saveSatellite(satellite);

        satellite = new Satellite();
        satellite.setName("Satellite 2");
        satelliteService.saveSatellite(satellite);


        File file = new File("C:\\Users\\Zhijiang Chen\\Desktop\\SO_info.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            //string information for file.txt
            String line;

            //set attributes for file.txt
            String SatelliteID = "";
            String Time = "";
            String X = "";
            String Y = "";
            String Z = "";
            String Vx = "";
            String Vy = "";
            String Vz = "";

            ArrayList list = new ArrayList();
            int index = 0;
            //Begin a transaction
            List<Status> statusList = new ArrayList<Status>();


            while ((line = br.readLine()) != null) {
                String[] splitSt = line.split(",");
                if (++index == 0) continue;

                    if (splitSt.length < line.length()) {
                        //set attributes
                        SatelliteID = splitSt[0];
                        Time = "2012-03-15T10:00:00Z";
                        X = splitSt[1];
                        Y = splitSt[2];
                        Z = splitSt[3];
                        Vx = splitSt[4];
                        Vy = splitSt[5];
                        Vz = splitSt[6];
                    }
                    //set data to mysql
                    Status status = new Status();

                    status.setSatellieID(Float.parseFloat(SatelliteID));
                    statusService.saveStatus(status);

                    status.setTime(Time);
                    statusService.saveStatus(status);

                    status.setX(Float.parseFloat(X));
                    statusService.saveStatus(status);

                    status.setY(Float.parseFloat(Y));
                    statusService.saveStatus(status);

                    status.setZ(Float.parseFloat(Z));
                    statusService.saveStatus(status);

                    status.setVx(Float.parseFloat(Vx));
                    statusService.saveStatus(status);

                    status.setVy(Float.parseFloat(Vy));
                    statusService.saveStatus(status);

                    status.setVz(Float.parseFloat(Vz));
                    statusService.saveStatus(status);

                    statusList.add(status);

                }
            } catch (IOException e) {
            e.printStackTrace();
        }
    }
        }


