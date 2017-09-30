package com.ift.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "satellite_id")
public class SatelliteID {

    @Id
    private String id;
    private String name;
    @OneToMany(mappedBy = "Satellite")
    private Set<SatellitePosition> satellitePositions;

    public SatelliteID(){

    }

    public SatelliteID(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @OneToMany(mappedBy = "satelliteID", cascade = CascadeType.ALL)
    public Set<SatellitePosition> getSatellitePositions() {
        return satellitePositions;
    }

    public void setSatellitePositions(Set<SatellitePosition> satellitePositions) {
        this.satellitePositions = satellitePositions;
    }

    @Override
    public String toString() {
        String result = String.format(
                "SatelliteID[id=%d, name='%s']%n",
                id, name);
        if (satellitePositions != null) {
            for(SatellitePosition satellitePosition : satellitePositions) {
                result += String.format(
                        "SatellitePosition[id=%d, name='%s']%n",
                        satellitePosition.getId(), satellitePosition.getName());
            }
        }

        return result;
    }
}