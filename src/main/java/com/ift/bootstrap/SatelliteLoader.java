package com.ift.bootstrap;

import com.ift.domain.*;
import com.ift.services.*;
import javafx.scene.text.Text;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Autowired
    SmSoInfoAllService smSoInfoAllService;

    @Autowired
    TimeLineService timeLineService;

    @Autowired
    BaseStationService baseStationService;

    @Autowired
    CollisionService collisionService;




    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

//        String fileName = "/Users/Timliu/Documents/monitor_so_info.txt";
//        try(Stream<String> stream = Files.lines(Paths.get(fileName))){
//            List<String> lines = stream.map(line-> {return line;}).collect(Collectors.toList());
//
//            lines.forEach(record->{
//                // To Array
//                String[] data = record.split(",");
//                int length = data.length;
//                String id = "";
//                String name = "";
//                String CartesianX = "";
//                String CartesianY = "";
//                String CartesianZ = "";
//                String PredefinedX = "";
//                String PredefinedY = "";
//                String PredefinedZ = "";
//                String Time = "";
//                String P1 = "";
//                String P2 = "";
//                String P3 = "";
//                String P4 = "";
//                String P5 = "";
//                String P6 = "";
//                String P7 = "";
//                String P8 = "";
//                String P9 = "";
//
//                ArrayList<String> cartesian = new ArrayList<>();
//                ArrayList<String> cartesianPre = new ArrayList<>();
//                ArrayList<String> timeStamps = new ArrayList<>();
//                ArrayList<String> p = new ArrayList<>();
//
//                for(int index = 0; index<length; index++){
//
//                    if(data[index].equalsIgnoreCase("id")){
//                        // Following data is id
//                        id = data[++index];
//                        continue;
//                    }
//                    if(data[index].equalsIgnoreCase("name")){
//                        // Following one data is name
//                        name = data[++index];
//                        continue;
//                    }
//                    if(data[index].equalsIgnoreCase("cartesian")){
//                        // group by 3, but beware of stupid.
//                        int cIndex = ++index;
//                        while(! data[cIndex].equalsIgnoreCase("predefined")){
//                            cartesian.add(data[cIndex]);
//                            cIndex++;
//                        }
//
//                        index = cIndex;
//                    }
//                    if(data[index].equalsIgnoreCase("predefined")){
//                        int pIndex = ++index;
//                        while (! data[pIndex].equalsIgnoreCase("timestamp")){
//                            cartesianPre.add(data[pIndex]);
//                            pIndex++;
//                        }
//
//                        index = pIndex;
//                    }
//                    if(data[index].equalsIgnoreCase("timestamp")){
//                        int tIndex = ++index;
//                        while (! data[tIndex].equalsIgnoreCase("p")){
//                            timeStamps.add(data[tIndex]);
//                            tIndex++;
//                        }
//
//                        index = tIndex;
//                    }
//                    if(data[index].equalsIgnoreCase("p")){
//                        int pIndex = ++index;
//                        while (pIndex < length) {
//                            p.add(data[pIndex]);
//                            pIndex++;
//                        }
//                        index = pIndex;
//                    }
//                }
//
//                MatlabSatellite matlabSatellite = new MatlabSatellite();
//
//
//                matlabSatellite.setSatelliteId(id);
//                matlabSatellite.setName(name);
//                matelabSatelliteService.saveMatlabSatellite(matlabSatellite);
//
//
//
//                for (int c = 0; c < cartesian.size() - 1; c+=3)
//
//                                try {
//
//                                    //loop here
//                                    CartesianX = cartesian.get(c);
//                                    CartesianY = cartesian.get(c+1);
//                                    CartesianZ = cartesian.get(c+2);
//                                    PredefinedX = cartesianPre.get(c);
//                                    PredefinedY = cartesianPre.get(c+1);
//                                    PredefinedZ = cartesianPre.get(c+2);
//                                    Time = timeStamps.get(c/3);
//                                    P1 = p.get(3*c);
//                                    P2 = p.get(3*c+1);
//                                    P3 = p.get(3*c+2);
//                                    P4 = p.get(3*c+3);
//                                    P5 = p.get(3*c+4);
//                                    P6 = p.get(3*c+5);
//                                    P7 = p.get(3*c+6);
//                                    P8 = p.get(3*c+7);
//                                    P9 = p.get(3*c+8);
//
//
//                                    //save to database
//                                    MonitorSoInfo monitorSoInfo = new MonitorSoInfo();
//                                    monitorSoInfo.setCartesianX(Double.valueOf(CartesianX));
//                                    monitorSoInfo.setCartesianY(Double.valueOf(CartesianY));
//                                    monitorSoInfo.setCartesianZ(Double.valueOf(CartesianZ));
//                                    monitorSoInfo.setPredefinedX(Double.valueOf(PredefinedX));
//                                    monitorSoInfo.setPredefinedY(Double.valueOf(PredefinedY));
//                                    monitorSoInfo.setPredefinedZ(Double.valueOf(PredefinedZ));
//                                    monitorSoInfo.setTimestamp(Time);
////                                    monitorSoInfo.setP1(Double.valueOf(P1));
////                                    monitorSoInfo.setP2(Double.valueOf(P2));
////                                    monitorSoInfo.setP3(Double.valueOf(P3));
////                                    monitorSoInfo.setP4(Double.valueOf(P4));
////                                    monitorSoInfo.setP5(Double.valueOf(P5));
////                                    monitorSoInfo.setP6(Double.valueOf(P6));
////                                    monitorSoInfo.setP7(Double.valueOf(P7));
////                                    monitorSoInfo.setP8(Double.valueOf(P8));
////                                    monitorSoInfo.setP9(Double.valueOf(P9));
////
//                                    monitorSoInfo.setP1(0.0026315);
//                                    monitorSoInfo.setP2(0.0019536);
//                                    monitorSoInfo.setP3(-0.86686);
//                                    monitorSoInfo.setP4(0.0019536);
//                                    monitorSoInfo.setP5(0.0089521);
//                                    monitorSoInfo.setP6(-2.0309);
//                                    monitorSoInfo.setP7(-0.86686);
//                                    monitorSoInfo.setP8(-2.0309);
//                                    monitorSoInfo.setP9(863.3642);
//
//                                    monitorSoInfo.setMatlabSatellite(matlabSatellite);
//                                    monitorSoInfoService.saveStatus(monitorSoInfo);
//
//                                    }catch (Exception ex){break;}
//
//            });
//
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//
//        //String base station data here
//        String fileName4 = "/Users/Timliu/Documents/bs_so_info.txt";
//
//        try(Stream<String> stream = Files.lines(Paths.get(fileName4))){
//            List<String> lines = stream.map(line-> {return line;}).collect(Collectors.toList());
//            lines.forEach(record->{
//
//                // To Array
//                String[] data = record.split(",");
//                int length = data.length;
//
//                String gsId = "";
//                String x = "";
//                String y = "";
//                String z = "";
//                ArrayList<String> gsData = new ArrayList<>();
//
//                for(int index = 0; index<length; index++) {
//
//                    if (data[index].equalsIgnoreCase("gsId")) {
//                        // Following data is id
//                        gsId = data[++index];
//                        continue;
//                    }
//
//                    if (data[index].equalsIgnoreCase("gsData")) {
//                        int pIndex = ++index;
//                        while (pIndex < length) {
//                            gsData.add(data[pIndex]);
//                            pIndex++;
//                        }
//                        index = pIndex;
//                    }
//                }
//
//                    for (int c = 0; c < gsData.size() - 1; c++)
//                        try {
//                            x = gsData.get(c);
//                            y = gsData.get(c + 1);
//                            z = gsData.get(c + 2);
//
//                            //save to database
//                            BaseStation baseStation = new BaseStation();
//                            baseStation.setBsid(gsId);
//                            baseStation.setX(Double.valueOf(x));
//                            baseStation.setY(Double.valueOf(y));
//                            baseStation.setZ(Double.valueOf(z));
//                            baseStationService.saveBaseStation(baseStation);
//                        } catch (Exception ex) {break;}
//                });
//
//
//            }catch(Exception ex){
//                ex.printStackTrace();
//            }
//
//        //SmSoInfoAll start here
//
//        String fileName2 = "/Users/Timliu/Documents/sm_so_info_all.txt";
//
//        try(Stream<String> stream = Files.lines(Paths.get(fileName2))){
//            List<String> lines = stream.map(line-> {return line;}).collect(Collectors.toList());
//            lines.forEach(record->{
//
//                // To Array
//                String[] data = record.split(",");
//                int length = data.length;
//
//                String SatelliteId = "";
//                String DataType = "";
//                String bsid = "";
//                String StartTime = "";
//                String EndTime = "";
//
//                for(int index = 0; index<length; index++) {
//
//                    if (data[index].equalsIgnoreCase("datatype")) {
//                        // Following data is id
//                        DataType = data[++index];
//                        continue;
//                    }
//                    if (data[index].equalsIgnoreCase("satelliteId")) {
//                        // Following one data is name
//                        SatelliteId = data[++index];
//                        continue;
//                    }
//                    if (data[index].equalsIgnoreCase("gsId")) {
//                        // Following one data is name
//                        bsid = data[++index];
//                        continue;
//                    }
//                    if (data[index].equalsIgnoreCase("availability")) {
//                        // Following one data is name
//                        String[] time = data[++index].split("/");
//                        StartTime = time[0];
//                        EndTime = time[1];
//                        break;
//                    }
//                }
//                    MatlabSatellite matlabSatellite = matelabSatelliteService.findBySatelliteId(SatelliteId);
//                    BaseStation baseStation = baseStationService.findByBaseId(bsid);
//
//                    SmSoInfoAll smSoInfoAll = new SmSoInfoAll();
//                    smSoInfoAll.setDataType(DataType);
//                    smSoInfoAll.setStartTime(StartTime);
//                    smSoInfoAll.setEndTime(EndTime);
//                    smSoInfoAll.setMatlabSatellite(matlabSatellite);
//                    smSoInfoAll.setBaseStation(baseStation);
//                    smSoInfoAllService.saveStatus(smSoInfoAll);
//
//                    });
//
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//
//        //String startTime and endTime for timeLine
//        String fileName3 = "/Users/Timliu/Documents/time_info.txt";
//
//        try(Stream<String> stream = Files.lines(Paths.get(fileName3))){
//            List<String> lines = stream.map(line-> {return line;}).collect(Collectors.toList());
//            lines.forEach(record->{
//
//                // To Array
//                String[] data = record.split(",");
//                int length = data.length;
//                String StartTime="";
//                String EndTime="";
//                for(int index = 0; index<length; index++) {
//                    if (data[index].equalsIgnoreCase("startTime")){
//                        StartTime = data[++index];
//                        continue;
//                    }
//                    if (data[index].equalsIgnoreCase("endTime")){
//                        EndTime = data[++index];
//                    }
//                }
//                TimeLine timeLine = new TimeLine();
//                timeLine.setStartTime(StartTime);
//                timeLine.setEndTime(EndTime);
//                timeLineService.saveTimeLine(timeLine);
//            });
//
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//
//        //SmSoInfoAll start here
//
//        String fileName5 = "/Users/Timliu/Documents/cp_so_info_opti.txt";
//
//        try(Stream<String> stream = Files.lines(Paths.get(fileName5))){
//            List<String> lines = stream.map(line-> {return line;}).collect(Collectors.toList());
//            lines.forEach(record->{
//
////                 To Array
//                String[] data = record.split(",");
//                int length = data.length;
//
//                String SatelliteId1 = "";
//                String SatelliteId2 = "";
//                String Time = "";
//                String CollisionData  = "";
//
//                for(int index = 0; index<length; index++) {
//
//                    if (data[index].equalsIgnoreCase("sid1")) {
//                        // Following data is id
//                        SatelliteId1 = data[++index];
//                        continue;
//                    }
//                    if (data[index].equalsIgnoreCase("sid2")) {
//                        // Following one data is name
//                        SatelliteId2 = data[++index];
//                        continue;
//                    }
//                    if (data[index].equalsIgnoreCase("timeData")) {
//                        int tIndex = index + 1;
//                        while (!data[tIndex].equalsIgnoreCase("collisionData")) {
//                            Time += data[tIndex] + ",";
//                            tIndex++;
//                        }
//                        Time = StringUtils.strip(Time, ",");
//                        index = tIndex;
//                    }
//                    if (data[index].equalsIgnoreCase("collisionData")) {
//                        int cIndex = index + 1;
//                        while (cIndex < length) {
//                            CollisionData += data[cIndex] + ",";
//                            cIndex++;
//                        }
//                        CollisionData = StringUtils.strip(CollisionData, ",");
//                        index = cIndex;
//                    }
//                }
//                MatlabSatellite matlabSatellite = matelabSatelliteService.findBySatelliteId(SatelliteId1);
//                MatlabSatellite matlabSatellite1 = matelabSatelliteService.findBySatelliteId(SatelliteId2);
//
//                Collision collision = new Collision();
//                collision.setSatellite1(matlabSatellite);
//                collision.setSatellite2(matlabSatellite1);
//                collision.setTime(Time);
//                collision.setCollisionData(CollisionData);
//                collisionService.saveCollision(collision);
//            });
//
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }







//        Satellite satellite = new Satellite();
//        satellite.setName("Satellite 1");
//        satelliteService.saveSatellite(satellite);
//
//        satellite = new Satellite();
//        satellite.setName("Satellite 2");
//        satelliteService.saveSatellite(satellite);

//        //new file
//        File file = new File("/Users/Timliu/Documents/so_info_revised_1000.txt");
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
//                String date = "2017-10-26T09:59:00";
//                DateTime dateTime = new DateTime(date);
//                org.joda.time.format.DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
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






