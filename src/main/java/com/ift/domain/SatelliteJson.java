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
    private String time;                            // Current time in millisecond
    private float speed;                            // Current satellite speed
    private int p_period;                           // propagation period (sec)
    private int p_steps;                            // how many times

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

    public int getP_period() {
        return p_period;
    }

    public void setP_period(int p_period) {
        this.p_period = p_period;
    }

    public int getP_steps() {
        return p_steps;
    }

    public void setP_steps(int p_steps) {
        this.p_steps = p_steps;
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
}
