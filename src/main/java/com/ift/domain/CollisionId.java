package com.ift.domain;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public class CollisionId {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;


    @ManyToOne
    @JoinColumn(name = "satelliteID1")
    private MatlabSatellite satellite1;

    @ManyToOne
    @JoinColumn(name = "satelliteID2")
    private MatlabSatellite satellite2;

    @OneToMany(mappedBy = "collsionMeta")
    private List<Collision> collisions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public List<Collision> getCollisions() {
        return collisions;
    }

    public void setCollisions(List<Collision> collisions) {
        this.collisions = collisions;
    }
}
