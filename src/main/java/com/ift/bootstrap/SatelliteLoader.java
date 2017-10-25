package com.ift.bootstrap;

import com.ift.domain.Satellite;
import com.ift.domain.SatellitePosition;
import com.ift.services.SatelliteService;
import com.ift.services.StatusService;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.joda.JodaDateTimeFormatAnnotationFormatterFactory;
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


//        File file = new File("SO_info_revised.txt");
//        String absolutePath = file.getAbsolutePath();
//
//        try (BufferedReader br = new BufferedReader(new FileReader(absolutePath))) {
//            //string information for file.txt
//            String line;
//
//            //set attributes for file.txt
//            String Id = "";
//            String Time = "";
//            String X = "";
//            String Y = "";
//            String Z = "";
//
//
//            int index = 0;
//            //Begin a transaction
//
//
//            while ((line = br.readLine()) != null) {
//                String[] splitSt = line.split(",");
//                if (++index == 0) continue;
//
//                Id = splitSt[0];
//                Satellite satellite = new Satellite();
//                satellite.setId("pre_" + Id);
//                satelliteService.saveSatellite(satellite);
//
//                String date = "2017-10-25T09:59:00";
//                DateTime dateTime = new DateTime(date);
//                DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
//
//                for (int i = 1; i < splitSt.length; i++)
//                    //set attributes
//                    try {
//                        dateTime = dateTime.plusMinutes(1);
//                        Time = dateTime.toString(fmt);
//                        X = splitSt[i++];
//                        Y = splitSt[i++];
//                        Z = splitSt[i];
//
//                        //set data to mysql
//                        SatellitePosition satellitePosition = new SatellitePosition();
//
////                        satellitePosition.setSatelliteID(satelliteID);
//                        satellitePosition.setTime(Time);
//                        satellitePosition.setX(Float.parseFloat(X) * 1000);
//                        satellitePosition.setY(Float.parseFloat(Y) * 1000);
//                        satellitePosition.setZ(Float.parseFloat(Z) * 1000);
//
//                        satellitePosition.setSatellite(satellite);
//
//                        statusService.saveStatus(satellitePosition);
//
//                    } catch (Exception ex) {
//                        break;
//                    }
//
//
//            }
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}






