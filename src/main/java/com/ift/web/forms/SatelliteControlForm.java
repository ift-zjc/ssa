package com.ift.web.forms;

import com.ift.domain.Satellite;

import java.util.List;

/**
 * Created by chen3 on 3/29/17.
 */
public class SatelliteControlForm {

    private String name;
    private List<Satellite> satelliteList;
    private List<Satellite> selectedSatellites;

    public List<Satellite> getSatelliteList() {
        return satelliteList;
    }

    public void setSatelliteList(List<Satellite> satelliteList) {
        this.satelliteList = satelliteList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Satellite> getSelectedSatellites() {
        return selectedSatellites;
    }

    public void setSelectedSatellites(List<Satellite> selectedSatellites) {
        this.selectedSatellites = selectedSatellites;
    }
}
