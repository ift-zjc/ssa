package com.ift.domain;


import javafx.scene.text.Text;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Collision {


    @ManyToOne
    @JoinColumn(name = "collectionMetaid")
    private CollisionId collsionMeta;

    @Id
    @GeneratedValue(generator="UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String time;
    private String collisionData;

    public CollisionId getCollsionMeta() {
        return collsionMeta;
    }

    public void setCollsionMeta(CollisionId collsionMeta) {
        this.collsionMeta = collsionMeta;
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
