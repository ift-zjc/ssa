/**
 * Created by chen3 on 3/30/17.
 */

var viewer;
$(function(){

    viewer = new Cesium.Viewer('cesiumContainer');

    // Connect to websocket
    connect();

    ajaxInit();
});


function ajaxInit() {

    $('#formSatellitesRefresh').on('submit', function(e){
        e.preventDefault();
        $.post("/satelliteDataRequest", function(data){
           console.log(data);

            viewer.dataSources.add(Cesium.CzmlDataSource.load(data));
        });

        // viewer.dataSources.add(Cesium.CzmlDataSource.load('/data/simple.czml'));

        return false;
    })
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
        stompClient.subscribe('/topic/satellite/data', function (greeting) {
            data = JSON.parse(greeting.body);

            viewer.dataSources.add(Cesium.CzmlDataSource.load(data));
        });
    });
}