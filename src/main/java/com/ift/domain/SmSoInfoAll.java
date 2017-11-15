package com.ift.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class SmSoInfoAll {

    @ManyToOne
    @JoinColumn(name = "satelliteID")
    private MatlabSatellite matlabSatellite;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String dataType;
    private String gsId;
    private String startTime;
    private String endTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getGsId() {
        return gsId;
    }

    public void setGsId(String gsId) {
        this.gsId = gsId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public SmSoInfoAll(){}

    public MatlabSatellite getMatlabSatellite() {
        return matlabSatellite;
    }

    public void setMatlabSatellite(MatlabSatellite matlabSatellite) {
        this.matlabSatellite = matlabSatellite;
    }

}
