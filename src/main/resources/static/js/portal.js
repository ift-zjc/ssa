/**
 * Created by chen3 on 3/30/17.
 */

var viewer;
$(function(){

    viewer = new Cesium.Viewer('cesiumContainer');

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