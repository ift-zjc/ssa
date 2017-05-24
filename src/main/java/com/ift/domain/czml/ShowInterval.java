package com.ift.domain.czml;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by chen3 on 5/24/17.
 */
public class ShowInterval {

    private String interval;
    @JsonProperty("boolean")
    private boolean show;

    public ShowInterval(String interval, boolean show){
        this.interval = interval;
        this.show = show;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
}
