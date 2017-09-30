package com.ift.domain;

import javax.persistence.*;

//create database entity
@Entity
public class SatellitePosition {
    private int id;
    private String name;
    private String time;

    @ManyToOne
    @JoinColumn(name = "satellite_id")
    private Satellite satellite;
    private float x;
    private float y;
    private float z;
    private float vx;
    private float vy;
    private float vz;

    public SatellitePosition() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId(){
        return id;
    }

    public void setId(int id) {
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

    public Satellite getSatellite() {
        return satellite;
    }

    public void setSatellite(Satellite satellite) {
        this.satellite = satellite;
    }
}

//    //set database attributes
//    @Id
//    @GeneratedValue(generator = "UUID")
//    private String id;
//
//    //set database columns with name and type
//    private float satelliteID;
//    private String time;
//    private String name;
//    private float x;
//    private float y;
//    private float z;
//    private float vx;
//    private float vy;
//    private float vz;
//
//    //database attributers
//    public String getId() {
//        return id;
//    }
//
//    public float getSatelliteID() {
//        return satelliteID;
//    }
//
//    public void setSatelliteID(float satelliteID) {
//        this.satelliteID = satelliteID;
//    }
//
//    public String getTime() {
//        return time;
//    }
//
//    public void setTime(String time) {
//        this.time = time;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public float getX() {
//        return x;
//    }
//
//    public void setX(float x) {
//        this.x = x;
//    }
//
//    public float getY() {
//        return y;
//    }
//
//    public void setY(float y) {
//        this.y = y;
//    }
//
//    public float getZ() {
//        return z;
//    }
//
//    public void setZ(float z) {
//        this.z = z;
//    }
//
//    public float getVx() {
//        return vx;
//    }
//
//    public void setVx(float vx) {
//        this.vx = vx;
//    }
//
//    public float getVy() {
//        return vy;
//    }
//
//    public void setVy(float vy) {
//        this.vy = vy;
//    }
//
//    public float getVz() {
//        return vz;
//    }
//
//    public void setVz(float vz) {
//        this.vz = vz;
//    }
//
//
//    @ManyToOne
//    @JoinColumn(name = "satellite_id")
//    public SatelliteID getSatelliteID() {
//        return satelliteID;
//    }
//
//    public void setSatelliteID(SatelliteID satelliteID){
//        this.satelliteID = satelliteID;
//    }
//}

