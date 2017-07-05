/**
 * Created by chen3 on 3/30/17.
 */


var viewer;
var czml;
var entity;

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
            "description": "Ground station #2",
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
                "text":"Station #2",
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
            "description": "Ground station #3",
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
                "text":"Station #3",
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
            "description": "Ground station #4",
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
                "text":"Station #4",
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
            "description": "Ground station #5",
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
                "text":"Station #5",
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
            "description": "Ground station #6",
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
                "text":"Station #6",
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
            "description": "Ground station #7",
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
                "text":"Station #7",
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
            "description": "Ground station #8",
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
                "text":"Station #8",
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
            "description": "Ground station #9",
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
                "text":"Station #9",
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
            "description": "Ground station #10",
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
                "text":"Station #10",
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
        baseLayerPicker : false,
        shadows: true
    });

    // viewer.dataSources.add(Cesium.CzmlDataSource.load(czml)).then(function(ds) {
    //     viewer.trackedEntity = ds.entities.getById('path');
    // });


    var entities = viewer.entities;

    var duration = 100; //seconds
    var frequency = 100; //hertz

    // var start = Cesium.JulianDate.fromDate(new Date());
    // var stop = Cesium.JulianDate.addSeconds(start, duration, new Cesium.JulianDate());

    var start = Cesium.JulianDate.fromIso8601('2012-03-15T09:00:00Z');
    var stop = Cesium.JulianDate.fromIso8601('2012-03-16T03:00:00Z');

    viewer.clock.startTime = start.clone();
    viewer.clock.stopTime = stop.clone();
    viewer.clock.currentTime = start.clone();
    viewer.clock.clockRange = Cesium.ClockRange.LOOP_STOP; //Loop at the end
    viewer.clock.multiplier = 2;
    viewer.timeline.zoomTo(start, stop);

    // Testing add ground station entity
    addGroundStation("abc", new Cesium.Cartesian3(-6161038.23150228,1339944.69084834,959470.404438937));

    viewer.zoomTo(viewer.entities);

    // var point = {
    //     lat: 40.0,
    //     lon: -75.0
    // };
    // var finalPoint = {
    //     lat: 40.0,
    //     lon: -175.0
    // };
    //
    // //generate a collection of position samples
    // var positions = calculatePositionSamples(point, finalPoint, start, duration, frequency);
    //
    // //create the entity
    // var target = entities.add({
    //     //Use our computed positions
    //     position: positions,
    //
    //     //Automatically compute orientation based on position movement.
    //     orientation: new Cesium.VelocityOrientationProperty(positions),
    //
    //     //Show the path
    //     path: {
    //         resolution: 1,
    //         material: new Cesium.PolylineGlowMaterialProperty({
    //             glowPower: 0.1,
    //             color: Cesium.Color.RED
    //         }),
    //         width: 5,
    //         trailTime: duration,
    //         leadTime: 0
    //     }
    // });


    var blueEllipse = viewer.entities.add({
        position: Cesium.Cartesian3.fromDegrees(-95.0, 40.0, 100000.0),
        name : 'Blue translucent, rotated, and extruded ellipse',
        ellipse : {
            semiMinorAxis : 150000.0,
            semiMajorAxis : 300000.0,
            extrudedHeight : 200000.0,  //拉伸
            rotation : Cesium.Math.toRadians(45), //旋转
            material : Cesium.Color.BLUE.withAlpha(0.7),
            outline : true
        }
    });

    var blueEllipsoid = viewer.entities.add({
        name : 'Blue ellipsoid',
        position: Cesium.Cartesian3.fromDegrees(-114.0, 40.0, 300000.0),
        ellipsoid : {
            //可以指定三个轴的半径
            radii : new Cesium.Cartesian3(200000.0, 200000.0, 300000.0),
            material : Cesium.Color.BLUE
        }
    });


    // means of our three dimensions
    var meanVector = [1, 2, 3];

    // covariance between dimensions. This examples makes the first and third
    // dimensions highly correlated, and the second dimension independent.
    var covarianceMatrix = [
        [ 1124.0, 0.0, 0.9 ],
        [ 0.0, 1211.0, 0.0 ],
        [ 0.9, 0.0, 1928.0 ],
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
function addSatellite(satelliteJson, init){

    var sId = satelliteJson.satelliteId;
    // Check for whether entity available.
    entity = viewer.entities.getById(sId);

    if(_.isUndefined(entity)){
        var emptyProperty = new Cesium.SampledPositionProperty();
        emptyProperty.setInterpolationOptions({
            interpolationDegree : 5,
            interpolationAlgorithm : Cesium.LagrangePolynomialApproximation
        });

        entity = viewer.entities.add({
            id: sId,
            // availability: satelliteJson.availability,
            billboard:{
                image: "/image/satellite.png",
                show: true
            },
            position: emptyProperty,
            // Automatically compute orientation based on position movement.
            orientation: new Cesium.VelocityOrientationProperty(emptyProperty),

            //Show the path
            path: {
                resolution: 1200,
                material: new Cesium.PolylineGlowMaterialProperty({
                    glowPower: 0.16,
                    color: Cesium.Color.RED
                }),
                width: 5,
                trailTime: 300,
                leadTime: 0
            }

        });
    }

    if(init){

    }else{
        var timeDataArray = satelliteJson.timeData.toString().split(",");
        var cartesian3DataArray = satelliteJson.satelliteData.toString().split(",");

        // Add sample data.
        var position = entity.position;

        // // Loop timedata array
        var index = 0;
        _.each(timeDataArray, function(timeData){
            cartesianData = cartesian3DataArray.slice(index, index+3);
            index = index+3;

            //position.addSample(Cesium.JulianDate.fromIso8601('2012-03-15T10:01:00Z'), new Cesium.Cartesian3(3169722.12564676,-2787480.80604407,-5661647.74541255));
            // Add to position
            entity.position.addSample(Cesium.JulianDate.fromIso8601(_.trim(timeData, "\"")), new Cesium.Cartesian3(cartesianData[0], cartesianData[1], cartesianData[2]));
        });
        // Set position and orientation.
        //
        // var index = 0;
        // for(var k = 0, len = timeDataArray.length; k<len; k++){
        //     //position.addSample(Cesium.JulianDate.fromIso8601('2012-03-15T10:01:00Z'), new Cesium.Cartesian3(3169722.12564676,-2787480.80604407,-5661647.74541255));
        //     position.addSample(Cesium.JulianDate.fromIso8601(timeDataArray[k]), new Cesium.Cartesian3(cartesian3DataArray[index++], cartesian3DataArray[index++], cartesian3DataArray[index++]));
        // }
        // position.addSample(Cesium.JulianDate.fromIso8601('2012-03-15T10:01:00Z'), new Cesium.Cartesian3(3169722.12564676,-2787480.80604407,-5661647.74541255));
        // position.addSample(Cesium.JulianDate.fromIso8601('2012-03-15T10:07:00Z'), new Cesium.Cartesian3(1369743.14695017,-1903662.23809705,-6663952.07552171));
        // entity.orientation = new Cesium.VelocityOrientationProperty(property);
    }

}

/**
 * @param point {{lat:number, lon:number }}
 * @param endPoint {{lat:number, lon:number }}
 * @param startTime {Cesium.JulianDate}
 * @param duration {number} Seconds to calculate for
 * @param intervalCount {number}
 * @return property {Cesium.SampledPositionProperty}
 */
function calculatePositionSamples(point, endPoint, startTime, duration, intervalCount) {
    var property = new Cesium.SampledPositionProperty();
    var deltaStep = duration / (intervalCount > 0 ? intervalCount : 1);

    var delta = {
        lon: (endPoint.lon - point.lon) / intervalCount,
        lat: (endPoint.lat - point.lat) / intervalCount
    };

    for (var since = 0; since <= duration; since += deltaStep) {
        property.addSample(
            Cesium.JulianDate.addSeconds(startTime, since, new Cesium.JulianDate()),
            Cesium.Cartesian3.fromDegrees(point.lon += delta.lon, point.lat += delta.lat)
        );
    }
    return property;
}


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

// dimensions highly correlated, and the second dimension independent.
var covarianceMatrix = [
    [ 1.0, 0.0, 0.9 ],
    [ 0.0, 1.0, 0.0 ],
    [ 0.9, 0.0, 1.0 ],
];

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
        stompClient.subscribe('/topic/satellite/matedata', function (matedata) {
            data = JSON.parse(matedata.body);
            this.addSatellite(data, true);

        });

        // Subscribe to relation data feeder
        stompClient.subscribe('/topic/satellite/relatedata', function (refdata){
            data = JSON.parse(refdata.body);
            this.addSatellite(data, false);
        });

        // Subscribe to satellite data feeder
        stompClient.subscribe('/topic/satellite/satellitedata', function (satellitedata){
            console.log("Data received");
            data = JSON.parse(satellitedata.body);

            this.addSatellite(data, false);

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