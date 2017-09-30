package com.ift.domain;

import javax.persistence.*;

//create database entity
@Entity
public class SatellitePosition {
    private Satellite satellite;
    private String id;
    private String name;
    private String time;
    private float x;
    private float y;
    private float z;
    private float vx;
    private float vy;
    private float vz;

    public SatellitePosition (){}
    public SatellitePosition(String name) {
        this.name = name;
    }
    public SatellitePosition (String name, Satellite satellite) {
        this.name = name;
        this.satellite = satellite;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public float getVx() {
        return vx;
    }

    public void setVx(float vx) {
        this.vx = vx;
    }

    public float getVy() {
        return vy;
    }

    public void setVy(float vy) {
        this.vy = vy;
    }

    public float getVz() {
        return vz;
    }

    public void setVz(float vz) {
        this.vz = vz;
    }

    @ManyToOne
    @JoinColumn(name = "satelliteID")
    public Satellite getSatellite() {
        return satellite;
    }

    public void setSatellite(Satellite satellite) {
        this.satellite = satellite;
    }
}
