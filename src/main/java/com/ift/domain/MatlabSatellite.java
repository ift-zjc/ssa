package com.ift.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class MatlabSatellite {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String satellite_id;
    private String name;

    @OneToMany(mappedBy = "matlabSatellite")
    private List<MonitorSoInfo> monitorSoInfos;

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

    public String getSatellite_id() {
        return satellite_id;
    }

    public void setSatellite_id(String satellite_id) {
        this.satellite_id = satellite_id;
    }

    public List<MonitorSoInfo> getMonitorSoInfos() {
        return monitorSoInfos;
    }

    public void setMonitorSoInfos(List<MonitorSoInfo> monitorSoInfos) {
        this.monitorSoInfos = monitorSoInfos;
    }
}
