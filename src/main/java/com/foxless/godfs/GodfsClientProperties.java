package com.foxless.godfs;

import com.foxless.godfs.bean.Tracker;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "godfs")
public class GodfsClientProperties {
    private String secret;
    private List<Tracker> trackers;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public List<Tracker> getTrackers() {
        return trackers;
    }

    public void setTrackers(List<Tracker> trackers) {
        this.trackers = trackers;
    }
}
