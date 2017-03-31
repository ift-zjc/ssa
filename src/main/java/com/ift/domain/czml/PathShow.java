package com.ift.domain.czml;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by chen3 on 3/31/17.
 */
public class PathShow implements Serializable {

    private String interval;
    private boolean display;

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    @JsonProperty("boolean")
    public boolean isDisplay() {
        return display;
    }

    public void setDisplay(boolean display) {
        this.display = display;
    }
}
