package com.ift.domain;

/**
 * Created by lastcow_chen on 6/16/17.
 */
public class SatelliteJsonItem {

    private String satelliteId;                     // Satellite id
    private String satelliteName;                   // Satellite name
    private float x;                                // Satellite location x
    private float y;                                // Satellite location y
    private float z;                                // Satellite location z
    private float vx;
    private float vy;
    private float vz;
    private String time;                            // Current time in millisecond
    private float speed;                            // Current satellite speed
    private int propagation_period;                           // propagation period (sec)
    private int propagation_steps;                            // how many times
    private String display_type;                    // image or dots

    public String getSatelliteId() {
        return satelliteId;
    }

    public void setSatelliteId(String satelliteId) {
        this.satelliteId = satelliteId;
    }

    public String getSatelliteName() {
        return satelliteName;
    }

    public void setSatelliteName(String satelliteName) {
        this.satelliteName = satelliteName;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getPropagation_period() {
        return propagation_period;
    }

    public void setPropagation_period(int propagation_period) {
        this.propagation_period = propagation_period;
    }

    public int getPropagation_steps() {
        return propagation_steps;
    }

    public void setPropagation_steps(int propagation_steps) {
        this.propagation_steps = propagation_steps;
    }

    public String getDisplay_type() {
        return display_type;
    }

    public void setDisplay_type(String display_type) {
        this.display_type = display_type;
    }
}
