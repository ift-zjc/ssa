package com.ift.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;


@Entity
public class BaseStation {


    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(unique = true)
    private String bsid;

    @OneToMany(mappedBy = "baseStation")
    private List<SmSoInfoAll> smSoInfoAlls;

    private double x;
    private double y;
    private double z;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<SmSoInfoAll> getSmSoInfoAlls() {
        return smSoInfoAlls;
    }

    public void setSmSoInfoAlls(List<SmSoInfoAll> smSoInfoAlls) {
        this.smSoInfoAlls = smSoInfoAlls;
    }

    public String getBsid() {
        return bsid;
    }

    public void setBsid(String bsid) {
        this.bsid = bsid;
    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
}
