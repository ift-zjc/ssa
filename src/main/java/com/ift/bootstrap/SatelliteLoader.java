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
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        String fileName = "/Users/Timliu/Documents/monitor_so_info.txt";
        try(Stream<String> stream = Files.lines(Paths.get(fileName))){
            List<String> lines = stream.map(line-> {return line;}).collect(Collectors.toList());

            lines.forEach(record->{
                // To Array
                String[] data = record.split(",");
                int length = data.length;
                String id = "";
                String name = "";
                String CartesianX = "";
                String CartesianY = "";
                String CartesianZ = "";
                String PredefinedX = "";
                String PredefinedY = "";
                String PredefinedZ = "";
                String Time = "";
                String P = "";

                ArrayList<String> cartesian = new ArrayList<>();
                ArrayList<String> cartesianPre = new ArrayList<>();
                ArrayList<String> timeStamps = new ArrayList<>();
                ArrayList<String> p = new ArrayList<>();

                for(int index = 0; index<length; index++){

                    if(data[index].equalsIgnoreCase("id")){
                        // Following data is id
                        id = data[++index];
                        continue;
                    }
                    if(data[index].equalsIgnoreCase("name")){
                        // Following one data is name
                        name = data[++index];
                        continue;
                    }
                    if(data[index].equalsIgnoreCase("cartesian")){
                        // group by 3, but beware of stupid.
                        int cIndex = ++index;
                        while(! data[cIndex].equalsIgnoreCase("predefined")){
                            cartesian.add(data[cIndex]);
                            cIndex++;
                        }

                        index = cIndex;
                    }
                    if(data[index].equalsIgnoreCase("predefined")){
                        int pIndex = ++index;
                        while (! data[pIndex].equalsIgnoreCase("timestamp")){
                            cartesianPre.add(data[pIndex]);
                            pIndex++;
                        }

                        index = pIndex;
                    }
                    if(data[index].equalsIgnoreCase("timestamp")){
                        int tIndex = ++index;
                        while (! data[tIndex].equalsIgnoreCase("p")){
                            timeStamps.add(data[tIndex]);
                            tIndex++;
                        }

                        index = tIndex;
                    }
                    if(data[index].equalsIgnoreCase("p")){
                        int pIndex = ++index;
                        while (pIndex < length) {
                            p.add(data[pIndex]);
                            pIndex++;
                        }
                        index = pIndex;
                    }
                }

                MatlabSatellite matlabSatellite = new MatlabSatellite();
//                MonitorSoInfo monitorSoInfo = new MonitorSoInfo();

                matlabSatellite.setSatellite_id(id);
                matlabSatellite.setName(name);
                matelabSatelliteService.saveMatlabSatellite(matlabSatellite);



//                for (int c = 0; c < cartesian.size()-1; c++) {
//                    CartesianX = cartesian.get(c++);
//                    CartesianY = cartesian.get(c++);
//                    CartesianZ = cartesian.get(c);
//                    for (int pre = 0; pre < cartesianPre.size() - 1; pre++) {
//                        PredefinedX = cartesianPre.get(pre++);
//                        PredefinedY = cartesianPre.get(pre++);
//                        PredefinedZ = cartesianPre.get(pre);
//                        for (int t = 0; t < timeStamps.size() - 1; t++) {
//                            Time = timeStamps.get(t++);
//                            for (int p1 = 0; p1 < p.size() - 1; p1++) {
//                                P = p.get(p1++);
//                                monitorSoInfo.setCartesianX(Double.valueOf(CartesianX));
//                                monitorSoInfo.setCartesianY(Double.valueOf(CartesianY));
//                                monitorSoInfo.setCartesianZ(Double.valueOf(CartesianZ));
//                                monitorSoInfo.setPredefinedX(Double.valueOf(PredefinedX));
//                                monitorSoInfo.setPredefinedY(Double.valueOf(PredefinedY));
//                                monitorSoInfo.setPredefinedZ(Double.valueOf(PredefinedZ));
//                                monitorSoInfo.setTimestamp(Time);
//                                monitorSoInfo.setP(Double.valueOf(P));
//                                monitorSoInfo.setMatlabSatellite(matlabSatellite);
//                                monitorSoInfoService.saveStatus(monitorSoInfo);
//                            }
//                        }
//                    }
//                }
            });


        }catch(Exception ex){
            ex.printStackTrace();
        }

//        Satellite satellite = new Satellite();
//        satellite.setName("Satellite 1");
//        satelliteService.saveSatellite(satellite);
//
//        satellite = new Satellite();
//        satellite.setName("Satellite 2");
//        satelliteService.saveSatellite(satellite);

        //new file

//        File file1 = new File("Monitor_SO_info.txt");
//        String monitorSoPath = file1.getPath();
//
//        try (BufferedReader br = new BufferedReader(new FileReader(monitorSoPath))){
//            String line;
//            String satellite_id = "";
//            String Name = "";
//            String CartesianX = "";
//            String CartesianY = "";
//            String CartesianZ = "";
//            String PredefinedX = "";
//            String PredefinedY = "";
//            String PredefinedZ = "";
//            String Time = "";
//            String P = "";
//
//            int index = 0;
//
//
//
//            while ((line = br.readLine()) !=null) {
//
//
//                    String[] splitSt = line.split(",");
//
//                    if (++index == 0) continue;
//                    satellite_id = splitSt[1];
//                    Name = splitSt[3];
//
//                    MatlabSatellite matlabSatellite = new MatlabSatellite();
//                    matlabSatellite.setSatellite_id(satellite_id);
//                    matlabSatellite.setName(Name);
//                    matelabSatelliteService.saveMatlabSatellite(matlabSatellite);
//
//                    for (int i = 5; i < splitSt.length; i++)
//                        //set attributes
//                        try {
//                            CartesianX = splitSt[i++];
//                            CartesianY = splitSt[i++];
//                            CartesianZ = splitSt[i];
//
//                            //set data to mysql
//                            MonitorSoInfo monitorSoInfo = new MonitorSoInfo();
//
////                        satellitePosition.setSatelliteID(satelliteID);
//                            monitorSoInfo.setName(Name);
//                            monitorSoInfo.setCartesianX(Double.valueOf(CartesianX));
//                            monitorSoInfo.setCartesianY(Double.valueOf(CartesianY));
//                            monitorSoInfo.setCartesianZ(Double.valueOf(CartesianZ));
//                            monitorSoInfo.setMatlabSatellite(matlabSatellite);
//                            monitorSoInfoService.saveStatus(monitorSoInfo);
//                        } catch (Exception ex) {
//                            break;
//                        }
//
//            }
//
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }



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






