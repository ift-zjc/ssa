package com.ift.domain;

import com.ift.common.Helper;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

//create database entity
@Entity
public class Status {

    //set database attributes
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    //set database columns with name and type
    private float satellieID;
    private String time;
    private float x;
    private float y;
    private float z;
    private float vx;
    private float vy;
    private float vz;

    //database attributers
    public String getId() { return id; }

    public float getSatellieID() { return satellieID; }
    public void setSatellieID(float satellieID) { this.satellieID = satellieID; }

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

    public float getVx() { return vx; }
    public void setVx(float vx) { this.vx = vx; }

    public float getVy() { return vy; }
    public void setVy(float vy) { this.vy = vy; }

    public float getVz() { return vz; }
    public void setVz(float vz) { this.vz = vz; }
}



