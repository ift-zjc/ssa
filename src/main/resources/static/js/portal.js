/**
 * Created by chen3 on 3/30/17.
 */


var viewer;
var czml;

$(function(){

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
        baseLayerPicker : false
    });

    viewer.dataSources.add(Cesium.CzmlDataSource.load(czml)).then(function(ds) {
        viewer.trackedEntity = ds.entities.getById('path');
    });


    // means of our three dimensions
    var meanVector = [1, 2, 3];

    // covariance between dimensions. This examples makes the first and third
    // dimensions highly correlated, and the second dimension independent.
    var covarianceMatrix = [
        [ 1.0, 0.0, 0.9 ],
        [ 0.0, 1.0, 0.0 ],
        [ 0.9, 0.0, 1.0 ],
    ];

    var distribution = window.MultivariateNormal.default(meanVector, covarianceMatrix);
    distribution.sample(); // => [1.2, 1.8, 3.3]

    var newDistribution = distribution.setMean([3, 2, 1]);
    newDistribution.sample(); // => [2.8, 2.1, 0.7]

    // distributions are immutable
    distribution.getMean(); // => [1, 2, 3];
    newDistribution.getMean(); // => [3, 2, 1];

    // File input bootstrap style
    $('input[type=file]').bootstrapFileInput();

    // Connect to websocket
    connect();

    ajaxInit();

});


function ajaxInit() {

    // $('#formSatellitesRefresh').on('submit', function(e){
    //     e.preventDefault();
    //     $.post("/satelliteDataRequest", function(data){
    //        console.log(data);
    //
    //         viewer.dataSources.add(Cesium.CzmlDataSource.load(data));
    //     });
    //
    //     // viewer.dataSources.add(Cesium.CzmlDataSource.load('/data/simple.czml'));
    //
    //     return false;
    // })


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
}

/**
 * Web socket connect to /sass-websocket
 */
function connect() {
    var socket = new SockJS('/sass-websocket');
    stompClient = Stomp.over(socket);

    stompClient.connect({}, function (frame) {
        // setConnected(true);
        console.log('Connected: ' + frame);

        // Subscribe to matedata feeder
        stompClient.subscribe('/topic/satellite/matedata', function (matedata) {
            data = JSON.parse(matedata.body);
            czml.push(data);
        });

        // Subscribe to satellite data feeder
        stompClient.subscribe('/topic/satellite/satellitedata', function (satellitedata){
            data = JSON.parse(satellitedata.body);

            // Add to czml.
            // Find data object for this satelliteId
            for(var i = 0; i < czml.length; i++){
                if(czml[i].id == data.satelliteId){
                    // Push data
                    czml[i].position.cartesian.push.apply(czml[i].position.cartesian, data.satelliteData);
                }
            }

            // Reload CZML file if completed
            if(data.completed){
                viewer.dataSources.add(Cesium.CzmlDataSource.load(czml));
            }
        })
    });
}