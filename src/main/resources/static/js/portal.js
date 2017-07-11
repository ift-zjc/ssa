/**
 * Created by chen3 on 3/30/17.
 */


var viewer;
var czml;
var entity;
var entityCollection;

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

    entityCollection = viewer.entities;

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
    viewer.clock.multiplier = 10;
    viewer.timeline.zoomTo(start, stop);

    // Testing add ground station entity

    // addSatellite({
    //     satelliteId: "abc1",
    //     satellitename: "abc1 name",
    //     satelliteDesc: "abc1 desc",
    //     satelliteAvailability: "2012-03-15T10:00:00Z/2012-03-16T02:40:00Z",
    //     satelliteEpoch: "2012-03-15T10:00:00Z",
    //     satelliteData: "-1.82883331973E7,-3.78265380199E7,-3187033.5797,-1.8122635387E7,-3.7907325447E7,-3178466.669,-1.79565899764E7,-3.79873857945E7,-3169838.794,-1.77902001591E7,-3.80667175455E7,-3161150.1215,-1.76234691353E7,-3.81453191974E7,-3152400.8199,-1.74564001115E7,-3.82231892615E7,-3143591.0585,-1.72889963008E7,-3.83003262633E7,-3134721.0079,-1.7121260922E7,-3.83767287425E7,-3125790.8396,-1.69531972007E7,-3.84523952527E7,-3116800.7266,-1.67848083681E7,-3.8527324362E7,-3107750.8427,-1.66160976619E7,-3.86015146526E7,-3098641.3631,-1.64470683255E7,-3.86749647208E7,-3089472.4639,-1.62777236083E7,-3.87476731773E7,-3080244.3226,-1.61080667658E7,-3.88196386471E7,-3070957.1176,-1.5938101059E7,-3.88908597696E7,-3061611.0285,-1.57678297549E7,-3.89613351982E7,-3052206.236,-1.5597256126E7,-3.9031063601E7,-3042742.922,-1.54263834505E7,-3.91000436603E7,-3033221.2694,-1.52552150123E7,-3.9168274073E7,-3023641.4623,-1.50837541005E7,-3.92357535503E7,-3014003.6859,-1.491200401E7,-3.93024808177E7,-3004308.1263,-1.47399680408E7,-3.93684546156E7,-2994554.9711,-1.45676494982E7,-3.94336736985E7,-2984744.4085,-1.4395051693E7,-3.94981368356E7,-2974876.6283,-1.42221779408E7,-3.95618428107E7,-2964951.8209,-1.40490315628E7,-3.96247904221E7,-2954970.1782,-1.38756158848E7,-3.96869784826E7,-2944931.8929,-1.37019342377E7,-3.97484058197E7,-2934837.1589,-1.35279899576E7,-3.98090712757E7,-2924686.1711,-1.33537863852E7,-3.98689737072E7,-2914479.1256,-1.31793268659E7,-3.99281119858E7,-2904216.2195,-1.30046147502E7,-3.99864849976E7,-2893897.6507,-1.28296533929E7,-4.00440916435E7,-2883523.6186,-1.26544461535E7,-4.0100930839E7,-2873094.3234,-1.24789963962E7,-4.01570015147E7,-2862609.9664,-1.23033074896E7,-4.02123026154E7,-2852070.7499,-1.21273828065E7,-4.02668331013E7,-2841476.8773,-1.19512257243E7,-4.0320591947E7,-2830828.553,-1.17748396246E7,-4.03735781421E7,-2820125.9824,-1.15982278931E7,-4.0425790691E7,-2809369.372,-1.14213939199E7,-4.04772286129E7,-2798558.9293,-1.12443410988E7,-4.05278909421E7,-2787694.8628,-1.1067072828E7,-4.05777767274E7,-2776777.3821,-1.08895925095E7,-4.0626885033E7,-2765806.6976,-1.0711903549E7,-4.06752149376E7,-2754783.021,-1.05340093564E7,-4.0722765535E7,-2743706.5648,-1.03559133451E7,-4.07695359342E7,-2732577.5425,-1.01776189321E7,-4.08155252588E7,-2721396.1687,-9999129.5384,-4.08607326476E7,-2710162.659,-9820448.5881,-4.09051572544E7,-2698877.2298,-9641579.5091,-4.09487982479E7,-2687540.0986",
    //     timeData: "2012-03-15T10:00:00Z,2012-03-15T10:01:00Z,2012-03-15T10:02:00Z,2012-03-15T10:03:00Z,2012-03-15T10:04:00Z,2012-03-15T10:05:00Z,2012-03-15T10:06:00Z,2012-03-15T10:07:00Z,2012-03-15T10:08:00Z,2012-03-15T10:09:00Z,2012-03-15T10:10:00Z,2012-03-15T10:11:00Z,2012-03-15T10:12:00Z,2012-03-15T10:13:00Z,2012-03-15T10:14:00Z,2012-03-15T10:15:00Z,2012-03-15T10:16:00Z,2012-03-15T10:17:00Z,2012-03-15T10:18:00Z,2012-03-15T10:19:00Z,2012-03-15T10:20:00Z,2012-03-15T10:21:00Z,2012-03-15T10:22:00Z,2012-03-15T10:23:00Z,2012-03-15T10:24:00Z,2012-03-15T10:25:00Z,2012-03-15T10:26:00Z,2012-03-15T10:27:00Z,2012-03-15T10:28:00Z,2012-03-15T10:29:00Z,2012-03-15T10:30:00Z,2012-03-15T10:31:00Z,2012-03-15T10:32:00Z,2012-03-15T10:33:00Z,2012-03-15T10:34:00Z,2012-03-15T10:35:00Z,2012-03-15T10:36:00Z,2012-03-15T10:37:00Z,2012-03-15T10:38:00Z,2012-03-15T10:39:00Z,2012-03-15T10:40:00Z,2012-03-15T10:41:00Z,2012-03-15T10:42:00Z,2012-03-15T10:43:00Z,2012-03-15T10:44:00Z,2012-03-15T10:45:00Z,2012-03-15T10:46:00Z,2012-03-15T10:47:00Z,2012-03-15T10:48:00Z,2012-03-15T10:49:00Z,2012-03-15T10:50:00Z"
    // });

    // addSatellite({
    //     satelliteId: "abc2",
    //     satellitename: "abc2 name",
    //     satelliteDesc: "abc2 desc",
    //     satelliteAvailability: "2012-03-15T10:00:00Z/2012-03-16T02:40:00Z",
    //     satelliteEpoch: "2012-03-15T10:00:00Z",
    //     satelliteData: "-1.28068049778E7,-4.00084370267E7,-3441574.1995,-1.26315888601E7,-4.00653244938E7,-3429999.9267,-1.24561306784E7,-4.01214441737E7,-3418359.9234,-1.22804337988E7,-4.01767950031E7,-3406654.4139,-1.2104501592E7,-4.02313759334E7,-3394883.6234,-1.19283374328E7,-4.02851859306E7,-3383047.7784,-1.17519447007E7,-4.03382239758E7,-3371147.107,-1.15753267793E7,-4.0390489065E7,-3359181.838,-1.13984870563E7,-4.04419802087E7,-3347152.2018,-1.12214289239E7,-4.04926964328E7,-3335058.4299,-1.1044155778E7,-4.05426367778E7,-3322900.755,-1.08666710189E7,-4.05918002991E7,-3310679.4112,-1.06889780504E7,-4.06401860672E7,-3298394.6336,-1.05110802807E7,-4.06877931674E7,-3286046.6586,-1.03329811214E7,-4.07346207002E7,-3273635.7239,-1.01546839881E7,-4.0780667781E7,-3261162.0681,-9976192.2999,-4.08259335401E7,-3248625.9313,-9797509.4798,-4.08704171229E7,-3236027.5548,-9618638.9541,-4.09141176898E7,-3223367.1808,-9439584.1528,-4.09570344165E7,-3210645.0529,-9260348.509,-4.09991664936E7,-3197861.4159,-9080935.4596,-4.10405131265E7,-3185016.5157,-8901348.4444,-4.10810735363E7,-3172110.5993,-8721590.9067,-4.11208469587E7,-3159143.915,-8541666.2928,-4.11598326448E7,-3146116.7122,-8361578.0522,-4.11980298608E7,-3133029.2415,-8181329.6373,-4.12354378879E7,-3119881.7545,-8000924.5035,-4.12720560228E7,-3106674.5041,-7820366.1093,-4.1307883577E7,-3093407.7442,-7639657.9157,-4.13429198776E7,-3080081.73,-7458803.3866,-4.13771642664E7,-3066696.7178,-7277805.9888,-4.14106161009E7,-3053252.9648,-7096669.1913,-4.14432747536E7,-3039750.7296,-6915396.4659,-4.14751396123E7,-3026190.2718,-6733991.2871,-4.15062100799E7,-3012571.8521,-6552457.1314,-4.15364855748E7,-2998895.7323,-6370797.4779,-4.15659655305E7,-2985162.1753,-6189015.808,-4.1594649396E7,-2971371.4451,-6007115.6052,-4.16225366352E7,-2957523.8068,-5825100.3553,-4.16496267276E7,-2943619.5266,-5642973.5461,-4.16759191681E7,-2929658.8718,-5460738.6675,-4.17014134666E7,-2915642.1105,-5278399.2112,-4.17261091485E7,-2901569.5123,-5095958.6708,-4.17500057546E7,-2887441.3476,-4913420.542,-4.1773102841E7,-2873257.8879,-4730788.322,-4.1795399979E7,-2859019.4058,-4548065.5096,-4.18168967554E7,-2844726.1748,-4365255.6055,-4.18375927724E7,-2830378.4697,-4182362.1117,-4.18574876475E7,-2815976.566,-3999388.5319,-4.18765810135E7,-2801520.7406,-3816338.371,-4.18948725188E7,-2787011.2711",
    //     timeData: "2012-03-15T10:00:00Z,2012-03-15T10:01:00Z,2012-03-15T10:02:00Z,2012-03-15T10:03:00Z,2012-03-15T10:04:00Z,2012-03-15T10:05:00Z,2012-03-15T10:06:00Z,2012-03-15T10:07:00Z,2012-03-15T10:08:00Z,2012-03-15T10:09:00Z,2012-03-15T10:10:00Z,2012-03-15T10:11:00Z,2012-03-15T10:12:00Z,2012-03-15T10:13:00Z,2012-03-15T10:14:00Z,2012-03-15T10:15:00Z,2012-03-15T10:16:00Z,2012-03-15T10:17:00Z,2012-03-15T10:18:00Z,2012-03-15T10:19:00Z,2012-03-15T10:20:00Z,2012-03-15T10:21:00Z,2012-03-15T10:22:00Z,2012-03-15T10:23:00Z,2012-03-15T10:24:00Z,2012-03-15T10:25:00Z,2012-03-15T10:26:00Z,2012-03-15T10:27:00Z,2012-03-15T10:28:00Z,2012-03-15T10:29:00Z,2012-03-15T10:30:00Z,2012-03-15T10:31:00Z,2012-03-15T10:32:00Z,2012-03-15T10:33:00Z,2012-03-15T10:34:00Z,2012-03-15T10:35:00Z,2012-03-15T10:36:00Z,2012-03-15T10:37:00Z,2012-03-15T10:38:00Z,2012-03-15T10:39:00Z,2012-03-15T10:40:00Z,2012-03-15T10:41:00Z,2012-03-15T10:42:00Z,2012-03-15T10:43:00Z,2012-03-15T10:44:00Z,2012-03-15T10:45:00Z,2012-03-15T10:46:00Z,2012-03-15T10:47:00Z,2012-03-15T10:48:00Z,2012-03-15T10:49:00Z,2012-03-15T10:50:00Z"
    // });

    // viewer.zoomTo(viewer.entities);

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


    // var blueEllipse = viewer.entities.add({
    //     position: Cesium.Cartesian3.fromDegrees(-95.0, 40.0, 100000.0),
    //     name : 'Blue translucent, rotated, and extruded ellipse',
    //     ellipse : {
    //         semiMinorAxis : 150000.0,
    //         semiMajorAxis : 300000.0,
    //         extrudedHeight : 200000.0,  //拉伸
    //         rotation : Cesium.Math.toRadians(45), //旋转
    //         material : Cesium.Color.BLUE.withAlpha(0.7),
    //         outline : true
    //     }
    // });
    //
    // var blueEllipsoid = viewer.entities.add({
    //     name : 'Blue ellipsoid',
    //     position: Cesium.Cartesian3.fromDegrees(-114.0, 40.0, 300000.0),
    //     ellipsoid : {
    //         //可以指定三个轴的半径
    //         radii : new Cesium.Cartesian3(200000.0, 200000.0, 300000.0),
    //         material : Cesium.Color.BLUE
    //     }
    // });


    // // means of our three dimensions
    // var meanVector = [1, 2, 3];
    //
    // // covariance between dimensions. This examples makes the first and third
    // // dimensions highly correlated, and the second dimension independent.
    // var covarianceMatrix = [
    //     [ 1124.0, 0.0, 0.9 ],
    //     [ 0.0, 1211.0, 0.0 ],
    //     [ 0.9, 0.0, 1928.0 ],
    // ];
    //
    // var distribution = window.MultivariateNormal.default(meanVector, covarianceMatrix);
    // distribution.sample(); // => [1.2, 1.8, 3.3]
    //
    // var newDistribution = distribution.setMean([3, 2, 1]);
    // newDistribution.sample(); // => [2.8, 2.1, 0.7]
    //
    // // distributions are immutable
    // distribution.getMean(); // => [1, 2, 3];
    // newDistribution.getMean(); // => [3, 2, 1];

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

    // Compute position
    var positions = new Cesium.SampledPositionProperty();
    var predefindedPositions = new Cesium.SampledPositionProperty();
    var timeDataArray = satelliteJson.timeData.toString().split(",");
    var cartesian3DataArray = satelliteJson.satelliteData.toString().split(",");
    var predefindedDataArray = satelliteJson.predefindedData.toString().split(",");

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

    // Availability
    // entity.availability = new Cesium.TimeIntervalCollection([
    //     new Cesium.TimeInterval({
    //         start: Cesium.JulianDate.fromIso8601("2012-03-15T10:00:00Z"),
    //         stop: Cesium.JulianDate.fromIso8601("2012-03-16T02:40:00Z")
    //     })]);

    // Billboard
    entity.billboard = new Cesium.BillboardGraphics();
    entity.billboard.image = "/image/satellite.png";
    entity.billboard.show = true;

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

    var path = new Cesium.PathGraphics();
    path.material = fadedLine;
    path.leadTime = new Cesium.ConstantProperty(0);
    path.trailTime = new Cesium.ConstantProperty(3600 * 1);

    entity.path = path;

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
        interpolationDegree : 5,
        interpolationAlgorithm : Cesium.LagrangePolynomialApproximation
    });

    viewer.entities.add(entity);

    // Compute predefined entity

    var entity = new Cesium.Entity({id: sId+"_predefined"});

    // Billboard
    entity.billboard = new Cesium.BillboardGraphics();
    entity.billboard.image = "/image/satellite.png";
    entity.billboard.show = true;

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

    var path = new Cesium.PathGraphics();
    path.material = fadedLine;
    path.leadTime = new Cesium.ConstantProperty(0);
    path.trailTime = new Cesium.ConstantProperty(3600 * 1);

    entity.path = path;

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
        interpolationDegree : 5,
        interpolationAlgorithm : Cesium.LagrangePolynomialApproximation
    });

    viewer.entities.add(entity);



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
        // stompClient.subscribe('/topic/satellite/matedata', function (matedata) {
        //     data = JSON.parse(matedata.body);
        //     this.addSatellite(data, true);
        //
        // });

        stompClient.subscribe('/topic/satellite/groundstations', function (gsdata){
           data = JSON.parse(gsdata.body);
            var cartesian3DataArray = data.gsData.toString().split(",");
            addGroundStation(data.gsId, Cesium.Cartesian3.fromDegrees(cartesian3DataArray[0], cartesian3DataArray[1], cartesian3DataArray[2]));
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