package com.ift.services;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by chen3 on 4/19/17.
 */

@Component
@ConfigurationProperties("storage")
public class StorageProperties {

    /**
     * Folder location for storing files location
     */
//    private String location = "/Users/lastcow_chen/Data";
    private String location = "/root/ssa/uploads";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
