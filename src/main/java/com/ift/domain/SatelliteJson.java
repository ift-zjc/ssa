package com.ift.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by chen3 on 5/1/17.
 */
public class SatelliteJson {

    private String sid;                             // Satellite id
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

    @SerializedName("uncertainty")
    private SatelliteJsonUncertainty uncertainty;   // Uncertainty, 6x6 array

    @SerializedName("BaseStations")
    private List<BaseStation> baseStationList;

    private class SatelliteJsonUncertainty {
        private float xx;
        private float xy;
        private float xz;

        public float getXx() {
            return xx;
        }

        public void setXx(float xx) {
            this.xx = xx;
        }

        public float getXy() {
            return xy;
        }

        public void setXy(float xy) {
            this.xy = xy;
        }

        public float getXz() {
            return xz;
        }

        public void setXz(float xz) {
            this.xz = xz;
        }
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
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

    public SatelliteJsonUncertainty getSatelliteJsonUncertainty() {
        return uncertainty;
    }

    public void setSatelliteJsonUncertanty(SatelliteJsonUncertainty satelliteJsonUncertainty) {
        this.uncertainty = satelliteJsonUncertainty;
    }

    public List<BaseStation> getBaseStationList() {
        return baseStationList;
    }

    public void setBaseStationList(List<BaseStation> baseStationList) {
        this.baseStationList = baseStationList;
    }

    public String getDisplay_type() {
        return display_type;
    }

    public void setDisplay_type(String display_type) {
        this.display_type = display_type;
    }
}
