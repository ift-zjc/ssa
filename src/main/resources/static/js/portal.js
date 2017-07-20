/**
 * Created by chen3 on 3/30/17.
 */


var viewer;
var czml;
var entity;
var entityCollection;
var satellites = [];
var satellitesPre = [];
var showPath = false;
var allConnection = 'a';
var optimizedConnection = 'o';
var ecAll = new Cesium.EntityCollection();
var ecOpt = new Cesium.EntityCollection();
var allIds = [];
var optIds = [];
var workerShowConnection;

$(function(){

    // Set EntityCollection's show = false
    ecAll.show = false;
    ecOpt.show = false;

    workerShowConnection = new Worker("/js/worker_show_connection.js");

    czml = [{
        "id": "document",
        "name": "SSA Project Data Visualization",
        "version": "1.0",
        "clock":{
            "interval":"2012-03-15T10:00:00Z/2012-03-16T10:00:00Z",
            "currentTime":"2012-03-15T10:00:00Z",
            "multiplier":60,
            "range":"LOOP_STOP",
            "step":"SYSTEM_CLOCK_MULTIPLIER"
        }
    }];

    Cesium.BingMapsApi.defaultKey = 'Ak8mO9f0VpoByuNwmMcVvFka1GCZ3Bh8VrpqNLqGtIgsuUYjTrJdw7kDZwAwlC7E';
    var terrainProvider = new Cesium.CesiumTerrainProvider({
        url : 'https://assets.agi.com/stk-terrain/world',
        requestVertexNormals : true
    });
    viewer = new Cesium.Viewer('cesiumContainer', {
        terrainProvider : terrainProvider,
        baseLayerPicker : false,
        shadows: true
    });

    entityCollection = viewer.entities;

    // viewer.dataSources.add(Cesium.CzmlDataSource.load(czml)).then(function(ds) {
    //     viewer.trackedEntity = ds.entities.getById('path');
    // });


    var entities = viewer.entities;

    var duration = 100; //seconds
    var frequency = 100; //hertz

    // var start = Cesium.JulianDate.fromDate(new Date());
    // var stop = Cesium.JulianDate.addSeconds(start, duration, new Cesium.JulianDate());

    viewer.clock.clockRange = Cesium.ClockRange.LOOP_STOP; //Loop at the end
    viewer.clock.multiplier = 10;

    // File input bootstrap style
    $('input[type=file]').bootstrapFileInput();

    // Connect to websocket
    connect();

    ajaxInit();

});

/**
 * Add ground station
 * @param gsId
 * @param cartesian3
 */
function addGroundStation(gsId, cartesian3){
    viewer.entities.add({
        id: gsId,
        position : cartesian3,
        billboard:{
            image: "/image/groundstation.png",
            show: true
        }
    });
}


/**
 * Add satellite data
 * @param sId
 * @param cartesian3
 */
function addSatellite(satelliteJson){

    var sId = satelliteJson.satelliteId;
    satellites.push(sId);

    // Compute position
    var positions = new Cesium.SampledPositionProperty();
    var predefindedPositions = new Cesium.SampledPositionProperty();
    var timeDataArray = satelliteJson.timeData.toString().split(",");
    var cartesian3DataArray = satelliteJson.satelliteData.toString().split(",");
    var predefindedDataArray = satelliteJson.predefindedData.toString().split(",");

    var point = new Cesium.PointGraphics({
        pixelSize: 5,
        color: Cesium.Color.RED
    });

    // Loop timedata array
    var index = 0;
    _.each(timeDataArray, function(timeData){
        var nodePosition = cartesian3DataArray.slice(index, index+3);
        var predefindedNodePosition = predefindedDataArray.slice(index, index+3);
        index = index+3;

        //position.addSample(Cesium.JulianDate.fromIso8601('2012-03-15T10:01:00Z'), new Cesium.Cartesian3(3169722.12564676,-2787480.80604407,-5661647.74541255));
        // Add to position
        positions.addSample(Cesium.JulianDate.fromIso8601(_.trim(timeData, "\"")), Cesium.Cartesian3.fromDegrees(nodePosition[0], nodePosition[1], nodePosition[2]));
        predefindedPositions.addSample(Cesium.JulianDate.fromIso8601(_.trim(timeData, "\"")), Cesium.Cartesian3.fromDegrees(predefindedNodePosition[0], predefindedNodePosition[1], predefindedNodePosition[2]));
    });

    // Compute entity
    var entity = new Cesium.Entity({id: sId});

    // Billboard
    // entity.billboard = new Cesium.BillboardGraphics();
    // entity.billboard.image = "/image/satellite.png";
    // entity.billboard.show = true;
    entity.point = point;

    // Position
    entity.position = positions;
    entity.orientation = new Cesium.VelocityOrientationProperty(positions);

    var fadedLine = new Cesium.StripeMaterialProperty({
        evenColor: Cesium.Color.YELLOW,
        oddColor: Cesium.Color.BLACK,
        repeat: 1,
        offset: 0.2,
        orientation: Cesium.StripeOrientation.VERTICAL
    });

    if(showPath) {
        var path = new Cesium.PathGraphics();
        path.material = fadedLine;
        path.leadTime = new Cesium.ConstantProperty(0);
        path.trailTime = new Cesium.ConstantProperty(3600 * 1);

        entity.path = path;
    }



    // Make a smooth path
    entity.position.setInterpolationOptions({
        interpolationDegree : 5,
        interpolationAlgorithm : Cesium.LagrangePolynomialApproximation
    });

    viewer.entities.add(entity);

    // Compute predefined entity

    var preId = sId+"_predefined";
    var entity = new Cesium.Entity({id: preId});
    satellitesPre.push(preId);

    // Billboard
    // entity.billboard = new Cesium.BillboardGraphics();
    // entity.billboard.image = "/image/satellite.png";
    // entity.billboard.show = true;


    entity.point = point;

    // Position
    entity.position = predefindedPositions;
    entity.orientation = new Cesium.VelocityOrientationProperty(positions);

    var fadedLine = new Cesium.StripeMaterialProperty({
        evenColor: Cesium.Color.RED,
        oddColor: Cesium.Color.BLACK,
        repeat: 1,
        offset: 0.2,
        orientation: Cesium.StripeOrientation.VERTICAL
    });

    if(showPath) {
        var path = new Cesium.PathGraphics();
        path.material = fadedLine;
        path.leadTime = new Cesium.ConstantProperty(0);
        path.trailTime = new Cesium.ConstantProperty(3600 * 1);

        entity.path = path;
    }


    // // Path
    // entity.path = new Cesium.PathGraphics({
    //     resolution: 1200,
    //
    //     material: new Cesium.PolylineGlowMaterialProperty({
    //                     glowPower: 0.16,
    //                     color: Cesium.Color.RED
    //                 }),
    //     width: new Cesium.ConstantProperty(10),
    //     leadTime: new Cesium.ConstantProperty(1e10),
    //     trailTime: new Cesium.ConstantProperty(1e10)
    // });

    // Make a smooth path
    entity.position.setInterpolationOptions({
        interpolationDegree : 1,
        interpolationAlgorithm : Cesium.LagrangePolynomialApproximation
    });

    viewer.entities.add(entity);

    // Creating samples


    // var covarianceMatrix = [
    //     [ 1124.0, 0.0, 0.9 ],
    //     [ 0.0, 1211.0, 0.0 ],
    //     [ 0.9, 0.0, 1928.0 ],
    // ];
    // Loop timedata array
    index = 0;
    var pIndex = 0
    _.each(timeDataArray, function(timeData){
        var nodePosition = cartesian3DataArray.slice(index, index+3);
        var uncertainty = satelliteJson.uncertainty.slice(pIndex, pIndex+9);
        index = index + 3;
        pIndex = pIndex + 9;

        var covarianceMatrix = [
            [ uncertainty[0], uncertainty[1], uncertainty[2] ],
            [ uncertainty[3], uncertainty[4], uncertainty[5] ],
            [ uncertainty[6], uncertainty[7], uncertainty[8] ]
        ];

        var distribution = window.MultivariateNormal.default([parseFloat(nodePosition[0]), parseFloat(nodePosition[1]), parseFloat(nodePosition[2])], covarianceMatrix);

        // get 100's for each point
        for(var j = 0; j< 100; j++){
            var sampleGenerated = distribution.sample();
            var sampleEntity = viewer.entities.getOrCreateEntity(sId + "_" + j);
            positions = sampleEntity.position;
            if(_.isUndefined(positions)){
                positions = new Cesium.SampledPositionProperty();
                sampleEntity.position = positions;
            }

            positions.addSample(Cesium.JulianDate.fromIso8601(_.trim(timeData, "\"")), Cesium.Cartesian3.fromDegrees(sampleGenerated[0], sampleGenerated[1], sampleGenerated[2]));

            sampleEntity.point = point;

        }
    });

}

/**
 * Add tracking line (dynamic)
 * @param obj1Id
 * @param obj2Id
 * @param availability
 */
function addTrackingLine(obj1Id, obj2Id, availability, datatype){

    var trackEntity = viewer.entities.add({
        polyline: {
            followSurface: false,
            positions: new Cesium.PositionPropertyArray([
                new Cesium.ReferenceProperty(
                    viewer.entities,
                    obj1Id,
                    [ 'position' ]
                ),
                new Cesium.ReferenceProperty(
                    viewer.entities,
                    obj2Id,
                    [ 'position' ]
                )
            ]),
            material: new Cesium.ColorMaterialProperty(
                Cesium.Color.YELLOW.withAlpha( 0.25 )
            )
        }
    });


    var availabilityArray = availability.split("/");
    trackEntity.availability = new Cesium.TimeIntervalCollection([
        new Cesium.TimeInterval({
            start: Cesium.JulianDate.fromIso8601(availabilityArray[0]),
            stop: Cesium.JulianDate.fromIso8601(availabilityArray[1])
        })]);

    trackEntity.show = true;

    // Add to array (id);
    if(datatype === allConnection){
        allIds.push(trackEntity.id);
        // ecAll.add(trackEntity);
    }else if(datatype === optimizedConnection){
        optIds.push(trackEntity.id);
        // ecOpt.add(trackEntity);
    }

    viewer.entities.add(trackEntity);
}


/**
 * File uploader init
 */
function ajaxInit() {

    $('#btnFileUploadSubmit').click(function(e){
        e.preventDefault();

        var fileUploadForm = $('#fileUploadForm')[0];
        var data = new FormData(fileUploadForm);
        $("#btnFileUploadSubmit").prop("disabled", true);
        $.ajax({
            type: "POST",
            enctype: "multipart/form-data",
            url: "/upload_config_file",
            data: data,
            processData: false,
            contentType: false,
            cache: false,
            timeout: 600000,
            success: function(data){
                console.log(data);
            },
            error: function(e){

            }

        }).done(function (data){
            $("#btnFileUploadSubmit").prop("disabled", false);
        });
        return false;
    });

    // Show path action
    $('#showPath').change(function(){
        if(this.checked){
            showPath = true;
            // Show path
            // Loop the entities
            var fadedLine = new Cesium.StripeMaterialProperty({
                evenColor: Cesium.Color.YELLOW,
                oddColor: Cesium.Color.BLACK,
                repeat: 1,
                offset: 0.2,
                orientation: Cesium.StripeOrientation.VERTICAL
            });

            var path = new Cesium.PathGraphics();
            path.material = fadedLine;
            path.leadTime = new Cesium.ConstantProperty(0);
            path.trailTime = new Cesium.ConstantProperty(3600 * 1);

            _.each(satellites, function(sid){

                var entity = viewer.entities.getById(sid);
                entity.path = path;
            });

            var fadedLine = new Cesium.StripeMaterialProperty({
                evenColor: Cesium.Color.RED,
                oddColor: Cesium.Color.BLACK,
                repeat: 1,
                offset: 0.2,
                orientation: Cesium.StripeOrientation.VERTICAL
            });
            var path = new Cesium.PathGraphics();
            path.material = fadedLine;
            path.leadTime = new Cesium.ConstantProperty(0);
            path.trailTime = new Cesium.ConstantProperty(3600 * 1);

            _.each(satellitesPre, function(sid){

                var entity = viewer.entities.getById(sid);
                entity.path = path;
            });

        }else{
            showPath = false;
            // Hide path

            _.each(satellites, function(sid){

                var entity = viewer.entities.getById(sid);
                entity.path = null;
            });

            _.each(satellitesPre, function(sid){

                var entity = viewer.entities.getById(sid);
                entity.path = null;
            });
        }
    });

    // Connection type selection
    $("input:radio[name='connOption']").change(function(){

        // ecAll.show = false;
        // ecOpt.show = false;

        var _val = $(this).val();
        if(_val == 'all'){
            // Show all connections.
            workerShowConnection.postMessage({show: 'all', allIds: allIds, optIds: optIds});
            // workerShowConnection.postMessage(ecAll, [ecAll]);
            // ecAll.show = true;
        }

        if(_val == 'optimized'){
            // Show optimized connections.
            workerShowConnection.postMessage({show: 'optimized', allIds: allIds, optIds: optIds});
        }
    });

    workerShowConnection.onmessage = function(event){
        console.log(event.data);
    }
}


/**
 * Web socket connect to /sass-websocket
 */
function connect() {
    var socket = new SockJS('/sass-websocket');
    stompClient = Stomp.over(socket);

    stompClient.connect({}, function (frame) {
        // setConnected(true);

        // Subscribe to metadata feeder
        // 100 random point's metadata added.
        // stompClient.subscribe('/topic/satellite/matedata', function (matedata) {
        //     data = JSON.parse(matedata.body);
        //     this.addSatellite(data, true);
        //
        // });

        stompClient.subscribe('/topic/satellite/cesiumMateData', function (metadata){
            data = JSON.parse(metadata.body);

            var start = Cesium.JulianDate.fromIso8601(data.startTime);
            var stop = Cesium.JulianDate.fromIso8601(data.endTime);

            viewer.clock.startTime = start.clone();
            viewer.clock.stopTime = stop.clone();

            viewer.timeline.zoomTo(start, stop);

        });

        stompClient.subscribe('/topic/satellite/groundstations', function (gsdata){
           data = JSON.parse(gsdata.body);
            var cartesian3DataArray = data.gsData.toString().split(",");
            addGroundStation(data.gsId, Cesium.Cartesian3.fromDegrees(cartesian3DataArray[0], cartesian3DataArray[1], cartesian3DataArray[2]));
        });

        // Subscribe to relation data feeder
        stompClient.subscribe('/topic/satellite/relatedata', function (refdata){
            data = JSON.parse(refdata.body);
            // Add tracking object , the array always has one element for now.
            try {
                this.addTrackingLine(data.satelliteId, data.gsId, data.availability[0], data.datatype);
            }catch(ex){
                // console.log(ex.toString());
            }
        });

        // Subscribe to satellite data feeder
        stompClient.subscribe('/topic/satellite/satellitedata', function (satellitedata){
            console.log("Data received");
            data = JSON.parse(satellitedata.body);

            this.addSatellite(data);

            console.log("data process completed");
        });

        // // Subscribe to data flag completed feeder
        // stompClient.subscribe('/topic/satellite/datacompleted', function (completedFlag){
        //     data = JSON.parse(completedFlag.body);
        //
        //     // Reload CZML file if completed
        //     if(data.completed){
        //         viewer.dataSources.add(Cesium.CzmlDataSource.load(czml));
        //     }
        // })
    });
}
