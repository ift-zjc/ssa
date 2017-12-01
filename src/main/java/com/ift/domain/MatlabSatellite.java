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

}
