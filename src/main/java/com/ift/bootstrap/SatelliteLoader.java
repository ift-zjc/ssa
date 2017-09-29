package com.ift.bootstrap;

import com.ift.common.Helper;
import com.ift.domain.Satellite;
import com.ift.domain.SatellitePosition;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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


        File file = new File("/Users/tianxiangliu/Desktop/SO_info.txt");

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
            List<SatellitePosition> statusList = new ArrayList<SatellitePosition>();


            while ((line = br.readLine()) != null) {
                String[] splitSt = line.split(",");
                if (++index == 0) continue;

                SatelliteID = splitSt[0];

                for(int i = 1; i<splitSt.length; i++)
                        //set attributes


                    try{
                    Time = "2012-03-15T10:00:00Z";
                    X = splitSt[i++];
                    Y = splitSt[i++];
                    Z = splitSt[i++];
                    Vx = splitSt[i++];
                    Vy = splitSt[i++];
                    Vz = splitSt[i++];

                    //set data to mysql
                    SatellitePosition satellitePosition = new SatellitePosition();

                    satellitePosition.setSatellieID(Float.parseFloat(SatelliteID));
                    satellitePosition.setTime(Time);
                    satellitePosition.setX(Float.parseFloat(X));
                    satellitePosition.setY(Float.parseFloat(Y));
                    satellitePosition.setZ(Float.parseFloat(Z));
                    satellitePosition.setVx(Float.parseFloat(Vx));
                    satellitePosition.setVy(Float.parseFloat(Vy));
                    satellitePosition.setVz(Float.parseFloat(Vz));

                    statusService.saveStatus(satellitePosition);
                    statusList.add(satellitePosition);

                }catch(Exception ex) {break;}




                }
            } catch (IOException e) {
            e.printStackTrace();
        }
    }
        }


