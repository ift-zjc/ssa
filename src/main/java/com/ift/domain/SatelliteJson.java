package com.ift.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by chen3 on 5/1/17.
 */
public class SatelliteJson {


    @SerializedName("satellites")
    private List<SatelliteJsonItem> satelliteJsonItem;

    @SerializedName("uncertainty")
    private SatelliteJsonUncertainty uncertainty;   // Uncertainty, 6x6 array

    @SerializedName("basestations")
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


    public List<SatelliteJsonItem> getSatelliteJsonItem() {
        return satelliteJsonItem;
    }

    public void setSatelliteJsonItem(List<SatelliteJsonItem> satelliteJsonItem) {
        this.satelliteJsonItem = satelliteJsonItem;
    }
}
