package com.ift.bootstrap;

import com.ift.domain.Satellite;
import com.ift.domain.SatellitePosition;
import com.ift.services.SatelliteService;
import com.ift.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
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

//        Satellite satellite = new Satellite();
//        satellite.setName("Satellite 1");
//        satelliteService.saveSatellite(satellite);
//
//        satellite = new Satellite();
//        satellite.setName("Satellite 2");
//        satelliteService.saveSatellite(satellite);


        File file = new File("/Users/lastcow_chen/Downloads/test1");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            //string information for file.txt
            String line;

            //set attributes for file.txt
            String Id = "";
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

                Id = splitSt[0];
                Satellite satellite = new Satellite();
                satellite.setId(Id);
                satelliteService.saveSatellite(satellite);


                for(int i = 2; i<splitSt.length; i++)
                        //set attributes
                    try{
                    Time = "2012-03-15T10:00:00Z";
                    X = splitSt[i++];
                    Y = splitSt[i++];
                    Z = splitSt[i++];
                    Vx = splitSt[i++];
                    Vy = splitSt[i++];
                    Vz = splitSt[i];

                    //set data to mysql
                    SatellitePosition satellitePosition = new SatellitePosition();

//                    satellitePosition.setSatelliteID(satelliteID);
                    satellitePosition.setTime(Time);
                    satellitePosition.setX(Float.parseFloat(X));
                    satellitePosition.setY(Float.parseFloat(Y));
                    satellitePosition.setZ(Float.parseFloat(Z));
                    satellitePosition.setVx(Float.parseFloat(Vx));
                    satellitePosition.setVy(Float.parseFloat(Vy));
                    satellitePosition.setVz(Float.parseFloat(Vz));

                    satellitePosition.setSatellite(satellite);

                    statusService.saveStatus(satellitePosition);
                    statusList.add(satellitePosition);

                }catch(Exception ex) {break;}




                }
            } catch (IOException e) {
            e.printStackTrace();
        }
    }
        }


