package com.ift.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by zhijiangchen on 3/28/17.
 */

@Entity
public class Satellite {

    private String id;
    private String satellite_id;
    private String name;


    public Satellite() {}
    public Satellite(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(generator="UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")

    public String getId() {
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

    public String getSatellite_id() {
        return satellite_id;
    }

    public void setSatellite_id(String satellite_id) {
        this.satellite_id = satellite_id;
    }

    @OneToMany(mappedBy = "satellite")
    private List<SatellitePosition> satellitePositions;
    public List<SatellitePosition> getSatellitePositions() {
        return satellitePositions;
    }

    public void setSatellitePositions(List<SatellitePosition> satellitePositions) {
        this.satellitePositions = satellitePositions;
    }
}

