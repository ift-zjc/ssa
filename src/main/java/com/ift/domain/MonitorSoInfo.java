package com.ift.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class MonitorSoInfo {

    @ManyToOne
    @JoinColumn(name = "satelliteID")
    private MatlabSatellite matlabSatellite;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String name;
    private double cartesianX;
    private double cartesianY;
    private double cartesianZ;
    private double predefinedX;
    private double predefinedY;
    private double predefinedZ;
    private String timestamp;
    private double p;

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

    public double getCartesianX() {
        return cartesianX;
    }

    public void setCartesianX(double cartesianX) {
        this.cartesianX = cartesianX;
    }

    public double getCartesianY() {
        return cartesianY;
    }

    public void setCartesianY(double cartesianY) {
        this.cartesianY = cartesianY;
    }

    public double getCartesianZ() {
        return cartesianZ;
    }

    public void setCartesianZ(double cartesianZ) {
        this.cartesianZ = cartesianZ;
    }

    public double getPredefinedX() {
        return predefinedX;
    }

    public void setPredefinedX(double predefinedX) {
        this.predefinedX = predefinedX;
    }

    public double getPredefinedY() {
        return predefinedY;
    }

    public void setPredefinedY(double predefinedY) {
        this.predefinedY = predefinedY;
    }

    public double getPredefinedZ() {
        return predefinedZ;
    }

    public void setPredefinedZ(double predefinedZ) {
        this.predefinedZ = predefinedZ;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public double getP() {
        return p;
    }

    public void setP(double p) {
        this.p = p;
    }

    public MonitorSoInfo(){}
    public MonitorSoInfo(String name, MatlabSatellite matlabSatellite) {
        this.name = name;
        this.matlabSatellite = matlabSatellite;
    }



    public MatlabSatellite getMatlabSatellite() {
        return matlabSatellite;
    }

    public void setMatlabSatellite(MatlabSatellite matlabSatellite) {
        this.matlabSatellite = matlabSatellite;
    }
}
