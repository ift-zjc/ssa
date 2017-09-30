package com.ift.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

/**
 * Created by zhijiangchen on 3/28/17.
 */

@Entity
public class Satellite {

    @Id
    @GeneratedValue(generator="UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String name;

    @OneToMany(mappedBy = "satellite_id")
    private List<SatellitePosition> satellitePosition;


    public String getId() {
        return id;
    }

    public void setId(String id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
