package com.ift.services;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by chen3 on 5/1/17.
 */

@Component
@ConfigurationProperties("zeromq")
public class ZeroMQProperties {

    private String url = "tcp://192.168.1.10:7575";

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
