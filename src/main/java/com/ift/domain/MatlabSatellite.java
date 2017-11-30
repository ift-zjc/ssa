package com.ift.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public class MatlabSatellite {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(unique = true)
    private String satelliteId;
    private String name;

    @OneToMany(mappedBy = "matlabSatellite")
    private List<MonitorSoInfo> monitorSoInfos;
    @OneToMany(mappedBy = "matlabSatellite")
    private List<SmSoInfoAll> smSoInfoAlls;
    @OneToMany(mappedBy = "satellite1")
    private List<Collision> collisions1;
    @OneToMany(mappedBy = "satellite2")
    private List<Collision> collisions2;

    public MatlabSatellite(){}
    public MatlabSatellite(String name) { this.name = name; }

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

    public String getSatelliteId() {
        return satelliteId;
    }

    public void setSatelliteId(String satelliteId) {
        this.satelliteId = satelliteId;
    }

    public List<MonitorSoInfo> getMonitorSoInfos() {
        return monitorSoInfos;
    }

    public void setMonitorSoInfos(List<MonitorSoInfo> monitorSoInfos) {
        this.monitorSoInfos = monitorSoInfos;
    }

    public List<SmSoInfoAll> getSmSoInfoAlls() {
        return smSoInfoAlls;
    }

    public void setSmSoInfoAlls(List<SmSoInfoAll> smSoInfoAlls) {
        this.smSoInfoAlls = smSoInfoAlls;
    }

    public List<Collision> getCollisions1() {
        return collisions1;
    }

    public void setCollisions1(List<Collision> collisions1) {
        this.collisions1 = collisions1;
    }

    public List<Collision> getCollisions2() {
        return collisions2;
    }

    public void setCollisions2(List<Collision> collisions2) {
        this.collisions2 = collisions2;
    }
}
