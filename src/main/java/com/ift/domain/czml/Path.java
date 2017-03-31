package com.ift.domain.czml;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.io.Serializable;

/**
 * Created by chen3 on 3/31/17.
 */

@JsonRootName(value = "path")
public class Path implements Serializable {

    public int getResolution() {
        return resolution;
    }

    public void setResolution(int resolution) {
        this.resolution = resolution;
    }

    private int resolution;
    private PathShow pathShow;

    @JsonProperty("show")
    public PathShow getPathShow() {
        return pathShow;
    }

    public void setPathShow(PathShow pathShow) {
        this.pathShow = pathShow;
    }
}
