package com.ift.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
public class MonitorSoInfo {

    @ManyToOne
    @JoinColumn(name = "satelliteID")
    private MatlabSatellite matlabSatellite;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private double cartesianX;
    private double cartesianY;
    private double cartesianZ;
    private double predefinedX;
    private double predefinedY;
    private double predefinedZ;
    private String timestamp;
    private double p1;
    private double p2;
    private double p3;
    private double p4;
    private double p5;
    private double p6;
    private double p7;
    private double p8;
    private double p9;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public double getP1() {
        return p1;
    }

    public void setP1(double p1) {
        this.p1 = p1;
    }

    public double getP2() {
        return p2;
    }

    public void setP2(double p2) {
        this.p2 = p2;
    }

    public double getP3() {
        return p3;
    }

    public void setP3(double p3) {
        this.p3 = p3;
    }

    public double getP4() {
        return p4;
    }

    public void setP4(double p4) {
        this.p4 = p4;
    }

    public double getP5() {
        return p5;
    }

    public void setP5(double p5) {
        this.p5 = p5;
    }

    public double getP6() {
        return p6;
    }

    public void setP6(double p6) {
        this.p6 = p6;
    }

    public double getP7() {
        return p7;
    }

    public void setP7(double p7) {
        this.p7 = p7;
    }

    public double getP8() {
        return p8;
    }

    public void setP8(double p8) {
        this.p8 = p8;
    }

    public double getP9() {
        return p9;
    }

    public void setP9(double p9) {
        this.p9 = p9;
    }

    public MonitorSoInfo(){}

    public MatlabSatellite getMatlabSatellite() {
        return matlabSatellite;
    }

    public void setMatlabSatellite(MatlabSatellite matlabSatellite) {
        this.matlabSatellite = matlabSatellite;
    }
}
