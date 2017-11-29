package com.ift.domain;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Collision {

    @ManyToOne
    @JoinColumn(name = "satelliteID")
    private MatlabSatellite satelliteId1;

    @ManyToOne
    @JoinColumn(name = "satelliteID")
    private MatlabSatellite satelliteId2;

    @Id
    @GeneratedValue(generator="UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String time;
    private double collisionData;

    public MatlabSatellite getSatelliteId1() {
        return satelliteId1;
    }

    public void setSatelliteId1(MatlabSatellite satelliteId1) {
        this.satelliteId1 = satelliteId1;
    }

    public MatlabSatellite getSatelliteId2() {
        return satelliteId2;
    }

    public void setSatelliteId2(MatlabSatellite satelliteId2) {
        this.satelliteId2 = satelliteId2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getCollisionData() {
        return collisionData;
    }

    public void setCollisionData(double collisionData) {
        this.collisionData = collisionData;
    }
}
