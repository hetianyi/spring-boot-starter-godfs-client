package com.foxless.godfs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.foxless.godfs.api.GodfsApiClient;
import com.foxless.godfs.bean.Tracker;
import com.foxless.godfs.config.ClientConfigurationBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@EnableConfigurationProperties(GodfsClientProperties.class)
public class GodfsAutoConfiguration {

    @Autowired
    private GodfsClientProperties godfsClientProperties;

    @Bean
    public ClientConfigurationBean clientConfigurationBean(GodfsClientProperties godfsClientProperties) {
        ClientConfigurationBean configuration = new ClientConfigurationBean();
        configuration.setSecret(godfsClientProperties.getSecret());
        List<Tracker> trackers = godfsClientProperties.getTrackers();
        if (null != trackers) {
            for (Tracker tracker : trackers) {
                configuration.addTracker(tracker);
            }
        }
        return configuration;
    }

    @Bean
    @Autowired
    public GoDFSClient goDFSClient(ClientConfigurationBean configurationBean) throws JsonProcessingException {
        GoDFSClient client = new GoDFSClient(configurationBean);
        client.start();
        return client;
    }

    @Bean
    public GodfsApiClient godfsApiClient(GoDFSClient goDFSClient) {
        return goDFSClient.getGodfsApiClient();
    }
}
