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
    },{
        "id": "Station1",
        "name": "Station 1",
        "description": "Ground station #1",
        "billboard":{
            "eyeOffset":{
                "cartesian":[
                    0,0,0
                ]
            },
            "horizontalOrigin":"CENTER",
            "image":"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAACvSURBVDhPrZDRDcMgDAU9GqN0lIzijw6SUbJJygUeNQgSqepJTyHG91LVVpwDdfxM3T9TSl1EXZvDwii471fivK73cBFFQNTT/d2KoGpfGOpSIkhUpgUMxq9DFEsWv4IXhlyCnhBFnZcFEEuYqbiUlNwWgMTdrZ3JbQFoEVG53rd8ztG9aPJMnBUQf/VFraBJeWnLS0RfjbKyLJA8FkT5seDYS1Qwyv8t0B/5C2ZmH2/eTGNNBgMmAAAAAElFTkSuQmCC",
            "pixelOffset":{
                "cartesian2":[
                    0,0
                ]
            },
            "scale":1.5,
            "show":true,
            "verticalOrigin":"CENTER"
        },
        "label":{
            "fillColor":{
                "rgba":[
                    0,255,255,255
                ]
            },
            "font":"11pt Lucida Console",
            "horizontalOrigin":"LEFT",
            "outlineColor":{
                "rgba":[
                    0,0,0,255
                ]
            },
            "outlineWidth":2,
            "pixelOffset":{
                "cartesian2":[
                    12,0
                ]
            },
            "show":true,
            "style":"FILL_AND_OUTLINE",
            "text":"Station #1",
            "verticalOrigin":"CENTER"
        },
        "position":{
            "cartesian":[
                1492313.11200032,-4457468.17767595,4296533.27301498
            ]
        }
    },
        {
            "id": "Station2",
            "name": "Station 2",
            "description": "Ground station #1",
            "billboard":{
                "eyeOffset":{
                    "cartesian":[
                        0,0,0
                    ]
                },
                "horizontalOrigin":"CENTER",
                "image":"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAACvSURBVDhPrZDRDcMgDAU9GqN0lIzijw6SUbJJygUeNQgSqepJTyHG91LVVpwDdfxM3T9TSl1EXZvDwii471fivK73cBFFQNTT/d2KoGpfGOpSIkhUpgUMxq9DFEsWv4IXhlyCnhBFnZcFEEuYqbiUlNwWgMTdrZ3JbQFoEVG53rd8ztG9aPJMnBUQf/VFraBJeWnLS0RfjbKyLJA8FkT5seDYS1Qwyv8t0B/5C2ZmH2/eTGNNBgMmAAAAAElFTkSuQmCC",
                "pixelOffset":{
                    "cartesian2":[
                        0,0
                    ]
                },
                "scale":1.5,
                "show":true,
                "verticalOrigin":"CENTER"
            },
            "label":{
                "fillColor":{
                    "rgba":[
                        0,255,255,255
                    ]
                },
                "font":"11pt Lucida Console",
                "horizontalOrigin":"LEFT",
                "outlineColor":{
                    "rgba":[
                        0,0,0,255
                    ]
                },
                "outlineWidth":2,
                "pixelOffset":{
                    "cartesian2":[
                        12,0
                    ]
                },
                "show":true,
                "style":"FILL_AND_OUTLINE",
                "text":"Station #1",
                "verticalOrigin":"CENTER"
            },
            "position":{
                "cartesian":[
                    -3852771.95796462,398145.251432722,5050382.17942545
                ]
            }
        },{
            "id": "Station3",
            "name": "Station 3",
            "description": "Ground station #1",
            "billboard":{
                "eyeOffset":{
                    "cartesian":[
                        0,0,0
                    ]
                },
                "horizontalOrigin":"CENTER",
                "image":"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAACvSURBVDhPrZDRDcMgDAU9GqN0lIzijw6SUbJJygUeNQgSqepJTyHG91LVVpwDdfxM3T9TSl1EXZvDwii471fivK73cBFFQNTT/d2KoGpfGOpSIkhUpgUMxq9DFEsWv4IXhlyCnhBFnZcFEEuYqbiUlNwWgMTdrZ3JbQFoEVG53rd8ztG9aPJMnBUQf/VFraBJeWnLS0RfjbKyLJA8FkT5seDYS1Qwyv8t0B/5C2ZmH2/eTGNNBgMmAAAAAElFTkSuQmCC",
                "pixelOffset":{
                    "cartesian2":[
                        0,0
                    ]
                },
                "scale":1.5,
                "show":true,
                "verticalOrigin":"CENTER"
            },
            "label":{
                "fillColor":{
                    "rgba":[
                        0,255,255,255
                    ]
                },
                "font":"11pt Lucida Console",
                "horizontalOrigin":"LEFT",
                "outlineColor":{
                    "rgba":[
                        0,0,0,255
                    ]
                },
                "outlineWidth":2,
                "pixelOffset":{
                    "cartesian2":[
                        12,0
                    ]
                },
                "show":true,
                "style":"FILL_AND_OUTLINE",
                "text":"Station #1",
                "verticalOrigin":"CENTER"
            },
            "position":{
                "cartesian":[
                    362352.839260321,5484433.46615372,3224938.64357144
                ]
            }
        },{
            "id": "Station4",
            "name": "Station 4",
            "description": "Ground station #1",
            "billboard":{
                "eyeOffset":{
                    "cartesian":[
                        0,0,0
                    ]
                },
                "horizontalOrigin":"CENTER",
                "image":"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAACvSURBVDhPrZDRDcMgDAU9GqN0lIzijw6SUbJJygUeNQgSqepJTyHG91LVVpwDdfxM3T9TSl1EXZvDwii471fivK73cBFFQNTT/d2KoGpfGOpSIkhUpgUMxq9DFEsWv4IXhlyCnhBFnZcFEEuYqbiUlNwWgMTdrZ3JbQFoEVG53rd8ztG9aPJMnBUQf/VFraBJeWnLS0RfjbKyLJA8FkT5seDYS1Qwyv8t0B/5C2ZmH2/eTGNNBgMmAAAAAElFTkSuQmCC",
                "pixelOffset":{
                    "cartesian2":[
                        0,0
                    ]
                },
                "scale":1.5,
                "show":true,
                "verticalOrigin":"CENTER"
            },
            "label":{
                "fillColor":{
                    "rgba":[
                        0,255,255,255
                    ]
                },
                "font":"11pt Lucida Console",
                "horizontalOrigin":"LEFT",
                "outlineColor":{
                    "rgba":[
                        0,0,0,255
                    ]
                },
                "outlineWidth":2,
                "pixelOffset":{
                    "cartesian2":[
                        12,0
                    ]
                },
                "show":true,
                "style":"FILL_AND_OUTLINE",
                "text":"Station #1",
                "verticalOrigin":"CENTER"
            },
            "position":{
                "cartesian":[
                    1839616.05824961,1111041.50316454,5985032.84766784
                ]
            }
        },{
            "id": "Station5",
            "name": "Station 5",
            "description": "Ground station #1",
            "billboard":{
                "eyeOffset":{
                    "cartesian":[
                        0,0,0
                    ]
                },
                "horizontalOrigin":"CENTER",
                "image":"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAACvSURBVDhPrZDRDcMgDAU9GqN0lIzijw6SUbJJygUeNQgSqepJTyHG91LVVpwDdfxM3T9TSl1EXZvDwii471fivK73cBFFQNTT/d2KoGpfGOpSIkhUpgUMxq9DFEsWv4IXhlyCnhBFnZcFEEuYqbiUlNwWgMTdrZ3JbQFoEVG53rd8ztG9aPJMnBUQf/VFraBJeWnLS0RfjbKyLJA8FkT5seDYS1Qwyv8t0B/5C2ZmH2/eTGNNBgMmAAAAAElFTkSuQmCC",
                "pixelOffset":{
                    "cartesian2":[
                        0,0
                    ]
                },
                "scale":1.5,
                "show":true,
                "verticalOrigin":"CENTER"
            },
            "label":{
                "fillColor":{
                    "rgba":[
                        0,255,255,255
                    ]
                },
                "font":"11pt Lucida Console",
                "horizontalOrigin":"LEFT",
                "outlineColor":{
                    "rgba":[
                        0,0,0,255
                    ]
                },
                "outlineWidth":2,
                "pixelOffset":{
                    "cartesian2":[
                        12,0
                    ]
                },
                "show":true,
                "style":"FILL_AND_OUTLINE",
                "text":"Station #1",
                "verticalOrigin":"CENTER"
            },
            "position":{
                "cartesian":[
                    -1538494.37727313,-5141106.22069336,3437876.94586717
                ]
            }
        },{
            "id": "Station6",
            "name": "Station 6",
            "description": "Ground station #1",
            "billboard":{
                "eyeOffset":{
                    "cartesian":[
                        0,0,0
                    ]
                },
                "horizontalOrigin":"CENTER",
                "image":"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAACvSURBVDhPrZDRDcMgDAU9GqN0lIzijw6SUbJJygUeNQgSqepJTyHG91LVVpwDdfxM3T9TSl1EXZvDwii471fivK73cBFFQNTT/d2KoGpfGOpSIkhUpgUMxq9DFEsWv4IXhlyCnhBFnZcFEEuYqbiUlNwWgMTdrZ3JbQFoEVG53rd8ztG9aPJMnBUQf/VFraBJeWnLS0RfjbKyLJA8FkT5seDYS1Qwyv8t0B/5C2ZmH2/eTGNNBgMmAAAAAElFTkSuQmCC",
                "pixelOffset":{
                    "cartesian2":[
                        0,0
                    ]
                },
                "scale":1.5,
                "show":true,
                "verticalOrigin":"CENTER"
            },
            "label":{
                "fillColor":{
                    "rgba":[
                        0,255,255,255
                    ]
                },
                "font":"11pt Lucida Console",
                "horizontalOrigin":"LEFT",
                "outlineColor":{
                    "rgba":[
                        0,0,0,255
                    ]
                },
                "outlineWidth":2,
                "pixelOffset":{
                    "cartesian2":[
                        12,0
                    ]
                },
                "show":true,
                "style":"FILL_AND_OUTLINE",
                "text":"Station #1",
                "verticalOrigin":"CENTER"
            },
            "position":{
                "cartesian":[
                    1907294.90566883,6030810.46906155,-817118.701669131
                ]
            }
        },{
            "id": "Station7",
            "name": "Station 7",
            "description": "Ground station #1",
            "billboard":{
                "eyeOffset":{
                    "cartesian":[
                        0,0,0
                    ]
                },
                "horizontalOrigin":"CENTER",
                "image":"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAACvSURBVDhPrZDRDcMgDAU9GqN0lIzijw6SUbJJygUeNQgSqepJTyHG91LVVpwDdfxM3T9TSl1EXZvDwii471fivK73cBFFQNTT/d2KoGpfGOpSIkhUpgUMxq9DFEsWv4IXhlyCnhBFnZcFEEuYqbiUlNwWgMTdrZ3JbQFoEVG53rd8ztG9aPJMnBUQf/VFraBJeWnLS0RfjbKyLJA8FkT5seDYS1Qwyv8t0B/5C2ZmH2/eTGNNBgMmAAAAAElFTkSuQmCC",
                "pixelOffset":{
                    "cartesian2":[
                        0,0
                    ]
                },
                "scale":1.5,
                "show":true,
                "verticalOrigin":"CENTER"
            },
            "label":{
                "fillColor":{
                    "rgba":[
                        0,255,255,255
                    ]
                },
                "font":"11pt Lucida Console",
                "horizontalOrigin":"LEFT",
                "outlineColor":{
                    "rgba":[
                        0,0,0,255
                    ]
                },
                "outlineWidth":2,
                "pixelOffset":{
                    "cartesian2":[
                        12,0
                    ]
                },
                "show":true,
                "style":"FILL_AND_OUTLINE",
                "text":"Station #1",
                "verticalOrigin":"CENTER"
            },
            "position":{
                "cartesian":[
                    -5466072.00649440,-2403990.61827738, 2242473.32662179
                ]
            }
        },{
            "id": "Station81",
            "name": "Station 8",
            "description": "Ground station #1",
            "billboard":{
                "eyeOffset":{
                    "cartesian":[
                        0,0,0
                    ]
                },
                "horizontalOrigin":"CENTER",
                "image":"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAACvSURBVDhPrZDRDcMgDAU9GqN0lIzijw6SUbJJygUeNQgSqepJTyHG91LVVpwDdfxM3T9TSl1EXZvDwii471fivK73cBFFQNTT/d2KoGpfGOpSIkhUpgUMxq9DFEsWv4IXhlyCnhBFnZcFEEuYqbiUlNwWgMTdrZ3JbQFoEVG53rd8ztG9aPJMnBUQf/VFraBJeWnLS0RfjbKyLJA8FkT5seDYS1Qwyv8t0B/5C2ZmH2/eTGNNBgMmAAAAAElFTkSuQmCC",
                "pixelOffset":{
                    "cartesian2":[
                        0,0
                    ]
                },
                "scale":1.5,
                "show":true,
                "verticalOrigin":"CENTER"
            },
            "label":{
                "fillColor":{
                    "rgba":[
                        0,255,255,255
                    ]
                },
                "font":"11pt Lucida Console",
                "horizontalOrigin":"LEFT",
                "outlineColor":{
                    "rgba":[
                        0,0,0,255
                    ]
                },
                "outlineWidth":2,
                "pixelOffset":{
                    "cartesian2":[
                        12,0
                    ]
                },
                "show":true,
                "style":"FILL_AND_OUTLINE",
                "text":"Station #1",
                "verticalOrigin":"CENTER"
            },
            "position":{
                "cartesian":[
                    -6161038.23150228,1339944.69084834,959470.404438937
                ]
            }
        },{
            "id": "Station9",
            "name": "Station 9",
            "description": "Ground station #1",
            "billboard":{
                "eyeOffset":{
                    "cartesian":[
                        0,0,0
                    ]
                },
                "horizontalOrigin":"CENTER",
                "image":"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAACvSURBVDhPrZDRDcMgDAU9GqN0lIzijw6SUbJJygUeNQgSqepJTyHG91LVVpwDdfxM3T9TSl1EXZvDwii471fivK73cBFFQNTT/d2KoGpfGOpSIkhUpgUMxq9DFEsWv4IXhlyCnhBFnZcFEEuYqbiUlNwWgMTdrZ3JbQFoEVG53rd8ztG9aPJMnBUQf/VFraBJeWnLS0RfjbKyLJA8FkT5seDYS1Qwyv8t0B/5C2ZmH2/eTGNNBgMmAAAAAElFTkSuQmCC",
                "pixelOffset":{
                    "cartesian2":[
                        0,0
                    ]
                },
                "scale":1.5,
                "show":true,
                "verticalOrigin":"CENTER"
            },
            "label":{
                "fillColor":{
                    "rgba":[
                        0,255,255,255
                    ]
                },
                "font":"11pt Lucida Console",
                "horizontalOrigin":"LEFT",
                "outlineColor":{
                    "rgba":[
                        0,0,0,255
                    ]
                },
                "outlineWidth":2,
                "pixelOffset":{
                    "cartesian2":[
                        12,0
                    ]
                },
                "show":true,
                "style":"FILL_AND_OUTLINE",
                "text":"Station #1",
                "verticalOrigin":"CENTER"
            },
            "position":{
                "cartesian":[
                    5064157.08250969,-498329.723659565,3832443.72700354
                ]
            }
        },{
            "id": "Station10",
            "name": "Station 10",
            "description": "Ground station #1",
            "billboard":{
                "eyeOffset":{
                    "cartesian":[
                        0,0,0
                    ]
                },
                "horizontalOrigin":"CENTER",
                "image":"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAACvSURBVDhPrZDRDcMgDAU9GqN0lIzijw6SUbJJygUeNQgSqepJTyHG91LVVpwDdfxM3T9TSl1EXZvDwii471fivK73cBFFQNTT/d2KoGpfGOpSIkhUpgUMxq9DFEsWv4IXhlyCnhBFnZcFEEuYqbiUlNwWgMTdrZ3JbQFoEVG53rd8ztG9aPJMnBUQf/VFraBJeWnLS0RfjbKyLJA8FkT5seDYS1Qwyv8t0B/5C2ZmH2/eTGNNBgMmAAAAAElFTkSuQmCC",
                "pixelOffset":{
                    "cartesian2":[
                        0,0
                    ]
                },
                "scale":1.5,
                "show":true,
                "verticalOrigin":"CENTER"
            },
            "label":{
                "fillColor":{
                    "rgba":[
                        0,255,255,255
                    ]
                },
                "font":"11pt Lucida Console",
                "horizontalOrigin":"LEFT",
                "outlineColor":{
                    "rgba":[
                        0,0,0,255
                    ]
                },
                "outlineWidth":2,
                "pixelOffset":{
                    "cartesian2":[
                        12,0
                    ]
                },
                "show":true,
                "style":"FILL_AND_OUTLINE",
                "text":"Station #1",
                "verticalOrigin":"CENTER"
            },
            "position":{
                "cartesian":[
                    -2419893.91337704,5402150.22161756,-2367224.44151113
                ]
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

        // Subscribe to relation data feeder
        stompClient.subscribe('/topic/satellite/relatedata', function (refdata){
            data = JSON.parse(refdata.body);
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
        });

        // Subscribe to data flag completed feeder
        stopmClient.subscribe('/topic/satellite/datacompleted', function (completedFlag){
            data = JSON.parse(satellitedata.body);

            // Reload CZML file if completed
            if(data.completed){
                viewer.dataSources.add(Cesium.CzmlDataSource.load(czml));
            }
        })
    });
}