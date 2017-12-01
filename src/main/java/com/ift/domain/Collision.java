package com.ift.domain;


import javafx.scene.text.Text;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Collision {

    @ManyToOne
    @JoinColumn(name = "satelliteID1")
    private MatlabSatellite satellite1;

    @ManyToOne
    @JoinColumn(name = "satelliteID2")
    private MatlabSatellite satellite2;

    @Id
    @GeneratedValue(generator="UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Lob
    private String time;
    @Lob
    private String collisionData;

    public MatlabSatellite getSatellite1() {
        return satellite1;
    }

    public void setSatellite1(MatlabSatellite satellite1) {
        this.satellite1 = satellite1;
    }

    public MatlabSatellite getSatellite2() {
        return satellite2;
    }

    public void setSatellite2(MatlabSatellite satellite2) {
        this.satellite2 = satellite2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCollisionData() {
        return collisionData;
    }

    public void setCollisionData(String collisionData) {
        this.collisionData = collisionData;
    }
}
