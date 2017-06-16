package com.ift.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by chen3 on 5/1/17.
 */
public class SatelliteJson {


    @SerializedName("satellites")
    private List<SatelliteJsonItem> satellites;


    @SerializedName("basestations")
    private List<BaseStation> basestations;

    public List<SatelliteJsonItem> getSatellites() {
        return satellites;
    }

    public void setSatellites(List<SatelliteJsonItem> satellites) {
        this.satellites = satellites;
    }

    public List<BaseStation> getBasestations() {
        return basestations;
    }

    public void setBasestations(List<BaseStation> basestations) {
        this.basestations = basestations;
    }
}
