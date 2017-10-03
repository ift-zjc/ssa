package com.ift.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

//create database entity
@Entity
public class SatellitePosition {


    @ManyToOne
    @JoinColumn(name = "satelliteID")
    private Satellite satellite;

    @Id
    @GeneratedValue(generator="UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String name;
    private String time;
    private float x;
    private float y;
    private float z;

    public SatellitePosition (){}
    public SatellitePosition(String name) {
        this.name = name;
    }
    public SatellitePosition (String name, Satellite satellite) {
        this.name = name;
        this.satellite = satellite;
    }

    public String getId(){
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public Satellite getSatellite() {
        return satellite;
    }

    public void setSatellite(Satellite satellite) {
        this.satellite = satellite;
    }
}
