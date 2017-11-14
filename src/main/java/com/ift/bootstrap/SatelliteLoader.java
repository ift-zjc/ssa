package com.ift.bootstrap;

import com.ift.domain.MatlabSatellite;
import com.ift.domain.MonitorSoInfo;
import com.ift.domain.Satellite;
import com.ift.domain.SatellitePosition;
import com.ift.services.MatelabSatelliteService;
import com.ift.services.MonitorSoInfoService;
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

import javax.print.attribute.standard.MediaSize;
import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.compress.compressors.CompressorStreamFactory.Z;

/**
 * Created by zhijiangchen on 3/28/17.
 */

@Component
public class SatelliteLoader implements ApplicationListener<ContextRefreshedEvent> {

    SatelliteService satelliteService;
    StatusService statusService;
    MonitorSoInfoService monitorSoInfoService;
    MatelabSatelliteService matelabSatelliteService;


    @Autowired
    void setSatelliteService(SatelliteService satelliteService) {
        this.satelliteService = satelliteService;
    }

    @Autowired
    void setStatusService(StatusService statusService) {
        this.statusService = statusService;
    }

    @Autowired
    void setMonitorSoInfoService(MonitorSoInfoService monitorSoInfoService) { this.monitorSoInfoService = monitorSoInfoService; }

    @Autowired
    void setMatelabSatelliteService(MatelabSatelliteService matelabSatelliteService) { this.matelabSatelliteService = matelabSatelliteService; }



    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

//        Satellite satellite = new Satellite();
//        satellite.setName("Satellite 1");
//        satelliteService.saveSatellite(satellite);
//
//        satellite = new Satellite();
//        satellite.setName("Satellite 2");
//        satelliteService.saveSatellite(satellite);

        //new file

        File file1 = new File("Monitor_SO_info.txt");
        String monitorSoPath = file1.getPath();

        try (BufferedReader br = new BufferedReader(new FileReader(monitorSoPath))){
            String line;
            String Id = "";
            String Name = "";
            String CartesianX = "";
            String CartesianY = "";
            String CartesianZ = "";
            String PredefinedX = "";
            String PredefinedY = "";
            String PredefinedZ = "";
            String Time = "";
            String P = "";

            int index = 0;

            while ((line = br.readLine()) !=null) {
                if (line.contains("predefined")) {
                    String[] splitSt = line.split(",");
                    if (++index == 0) continue;
                    Id = splitSt[1];
                    Name = splitSt[3];

                    MatlabSatellite matlabSatellite = new MatlabSatellite();
                    matlabSatellite.setId(Id);
                    matlabSatellite.setName(Name);
                    matelabSatelliteService.saveMatlabSatellite(matlabSatellite);

                    for (int i = 5; i < splitSt.length; i++)
                        //set attributes
                        try {
                            CartesianX = splitSt[i++];
                            CartesianY = splitSt[i++];
                            CartesianZ = splitSt[i];

                            //set data to mysql
                            MonitorSoInfo monitorSoInfo = new MonitorSoInfo();

//                        satellitePosition.setSatelliteID(satelliteID);
                            monitorSoInfo.setName(Name);
                            monitorSoInfo.setCartesianX(Double.valueOf(CartesianX));
                            monitorSoInfo.setCartesianY(Double.valueOf(CartesianY));
                            monitorSoInfo.setCartesianZ(Double.valueOf(CartesianZ));
                            monitorSoInfo.setMatlabSatellite(matlabSatellite);
                            monitorSoInfoService.saveStatus(monitorSoInfo);

                        } catch (Exception ex) {
                            break;
                        }
                            }
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }



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
//                String date = "2017-10-27T09:59:00";
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
//                        satellitePosition.setX(Float.parseFloat(X) * 1);
//                        satellitePosition.setY(Float.parseFloat(Y) * 1);
//                        satellitePosition.setZ(Float.parseFloat(Z) * 1);
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






