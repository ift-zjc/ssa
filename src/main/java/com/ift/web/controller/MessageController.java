package com.ift.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ift.domain.czml.*;
import org.apache.log4j.Logger;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen3 on 4/4/17.
 */

@Controller
public class MessageController {

    private static final Logger LOGGER = Logger.getLogger(MessageController.class.getName());

    @MessageMapping("/data/satellite")
    @SendTo("/topic/satellite/data")
    public String satelliteData() throws Exception {
        Thread.sleep(1000); // simulated delay


        List<CzmlObj> czmlObjs = new ArrayList<CzmlObj>();
        // First element must with id = document
        CzmlObj czmlObj = new CzmlObj();
        czmlObj.setId("document");
        czmlObj.setName("IFT Satellites Monitoring");
        czmlObj.setVersion("1.0");
        Clock clock = new Clock();
        clock.setInterval("2016-03-15T10:00:00Z/2016-03-22T10:00:00Z");
        clock.setCurrentTime("2016-03-20T10:00:00Z");
        clock.setMultiplier(30);
        clock.setRange("LOOP_STOP");
        clock.setStep("SYSTEM_CLOCK_MULTIPLIER");
        czmlObj.setClock(clock);

        czmlObjs.add(czmlObj);

        czmlObj = new CzmlObj();
        czmlObj.setId("test satellite");
        czmlObj.setName("Test Satellite");
        czmlObj.setDescription("Click me");
        czmlObj.setAvailability("2016-03-15T10:00:00Z/2016-03-20T10:00:00Z");
        Billboard billboard = new Billboard();
        billboard.setImage("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAADJSURBVDhPnZHRDcMgEEMZjVEYpaNklIzSEfLfD4qNnXAJSFWfhO7w2Zc0Tf9QG2rXrEzSUeZLOGm47WoH95x3Hl3jEgilvDgsOQUTqsNl68ezEwn1vae6lceSEEYvvWNT/Rxc4CXQNGadho1NXoJ+9iaqc2xi2xbt23PJCDIB6TQjOC6Bho/sDy3fBQT8PrVhibU7yBFcEPaRxOoeTwbwByCOYf9VGp1BYI1BA+EeHhmfzKbBoJEQwn1yzUZtyspIQUha85MpkNIXB7GizqDEECsAAAAASUVORK5CYII=");
        billboard.setScale(1.5d);
        billboard.setShow(true);
        czmlObj.setBillboard(billboard);

        Position position = new Position();
        position.setInterpolationAlgorithm("LAGRANGE");
        position.setInterpolationDegree(5);
        position.setReferenceFrame("INERTIAL");
        position.setEpoch("2016-03-15T11:00:00Z");
        ArrayList<Double> positionList = fillPosition( 0d,4650397.56551457,-3390535.52275848,-4087729.48877329,
                300d,3169722.12564676,-2787480.80604407,-5661647.74541255,
                600d,1369743.14695017,-1903662.23809705,-6663952.07552171,
                900d,-567881.181741598,-828602.646229013,-6995188.66804375,
                1200d,-2448582.60230996,329568.153528487,-6623075.06683579,
                1500d,-4083754.13823344,1454683.10708859,-5585143.37246992,
                1800d,-5308969.50307564,2433751.75579502,-3985152.1306503,
                2100d,-6000251.41586053,3168038.65147806,-1983402.41619314,
                2400d,-6086888.59948749,3583071.0890244,218668.596985674,
                2700d,-5559191.47781264,3636465.81402216,2398566.73167249,
                3e3d,-4469920.08845903,3322511.24085064,4335511.55404767,
                3300d,-2928982.78408199,2672830.22757979,5833216.31169719,
                3600d,-1092083.75801192,1753068.15442214,6739938.26134568,
                3900d,855172.482158128,656135.125613598,6963670.20631676,
                4200d,2715900.15544456,-507141.10370753,6481233.35568881,
                4500d,4301545.02457765,-1619032.41301719,5340730.82941359,
                4800d,5450887.61456272,-2566695.71952053,3657168.90089312,
                5100d,6046743.71636896,-3253730.76621873,1601308.71661883,
                5400d,6028480.33195964,-3610312.82817681,-617627.593798261,
                5700d,5398572.81294241,-3600605.84777646,-2773801.46073176,
                6e3d,4222131.44045066,-3226403.44705845,-4648544.33370408,
                6300d,2619506.22498348,-2526553.4640733,-6052998.81756411,
                6600d,753243.717795414,-1572460.33494755,-6846895.76189552,
                6900d,-1188681.40488625,-460501.299931452,-6951744.44608042,
                7200d,-3011438.3543463,697635.55422786,-6357762.60297625,
                7500d,-4532151.11938648,1785788.3012355,-5124499.63066102,
                7800d,-5597650.73991331,2694559.67974802,-3375267.6308537,
                8100d,-6099819.6602219,3332144.87819992,-1285551.25441976,
                8400d,-5986960.96848025,3633749.04814585,934060.845169727,
                8700d,-5269630.81665556,3568466.92847822,3059081.28082907,
                9e3d,-4019895.75365332,3142650.51265407,4874208.829971,
                9300d,-2363959.24834243,2399275.2584582,6195511.03850927,
                9600d,-469149.870760219,1413453.85724258,6889101.23661198,
                9900d,1473060.67181718,284763.40426175,6884461.2201842,
                10200d,3266189.40343301,-872716.655583284,6181432.05126297,
                10500d,4728347.28355441,-1941746.59348253,4850477.39746136,
                10800d,5710710.2309505,-2813734.86048061,3026098.49087128,
                11100d,6113095.13961986,-3399958.81868676,893596.861584693,
                11400d,5894739.57129755,-3640946.46595729,-1329913.85220463,
                11700d,5078666.83994692,-3512760.54879695,-3418301.78745728,
                1.2e4d,3748910.95111879,-3029296.38333698,-5160170.44648529,
                12300d,2041115.54074956,-2240388.77388782,-6380510.87024598,
                12600d,128062.841689814,-1226230.06015728,-6957810.72494893,
                12900d,-1797880.02370018,-89029.4500196064,-6835259.47179512,
                13200d,-3543573.22088694,1057095.05449295,-6025636.92847326,
                13500d,-4933723.66130957,2097142.52871785,-4609929.79883268,
                13800d,-5828032.08592363,2926410.8376128,-2729797.16692992,
                14100d,-6135448.82449735,3460972.29119284,-574126.701345544,
                14400d,-5823927.7453399,3646385.46288723,1639558.19879141,
                14700d,-4924221.58519395,3463528.69521585,3687192.93154295,
                1.5e4d,-3526959.31596672,2930706.251085,5361276.70706965);
        position.setCartesian(positionList);
        czmlObj.setPosition(position);
        PathShow pathShow = new PathShow();
        pathShow.setDisplay(true);
        pathShow.setInterval("2016-03-15T10:00:00Z/2016-03-20T10:00:00Z");
        Path path = new Path();
        path.setResolution(120);
        path.setPathShow(pathShow);
        czmlObj.setPath(path);

        czmlObjs.add(czmlObj);

        String jsonStr = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            jsonStr= mapper.writeValueAsString(czmlObjs);
        }catch(Exception ex){
            LOGGER.error(ex);
        }
        return jsonStr;
    }

    /**
     * Position list fillup
     * @param data
     * @return
     */
    private ArrayList<Double> fillPosition( Double... data){
        ArrayList<Double> positionList = new ArrayList<Double>();
        for (double item: data) {
            positionList.add(item);
        }

        return positionList;
    }
}
