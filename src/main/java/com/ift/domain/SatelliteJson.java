package com.ift.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by chen3 on 5/1/17.
 */
public class SatelliteJson {

    private String sid;                             // Satellite id
    private float x;                                // Satellite location x
    private float y;                                // Satellite location y
    private float z;                                // Satellite location z
    private double time;                            // Current time in millionsecond
    private float speed;                            // Current satellite speed

    @SerializedName("uncertainty")
    private SatelliteJsonUncertainty uncertainty;   // Uncertainty, 6x6 array

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

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public SatelliteJsonUncertainty getSatelliteJsonUncertainty() {
        return uncertainty;
    }

    public void setSatelliteJsonUncertanty(SatelliteJsonUncertainty satelliteJsonUncertainty) {
        this.uncertainty = satelliteJsonUncertainty;
    }
}
