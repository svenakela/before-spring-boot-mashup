package com.trustly.robocops;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import com.trustly.robocops.logic.CacheProperties;
import com.trustly.robocops.logic.CacheService;
import com.trustly.robocops.logic.impl.CacheServiceImpl;
import com.trustly.robocops.resource.RobocopSinglePointController;

@Configuration
public class MyLittleConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyLittleConfig.class);

    @Bean
    public RobocopSinglePointController rspc(final CacheService cache, final CacheProperties props) {
        return new RobocopSinglePointController(cache);
    }

    @Bean
    public CacheService robocopCache(final CacheProperties properties) {
        return new CacheServiceImpl(properties);
    }

    @Bean
    @ConfigurationProperties(prefix = "trustly.robocops.cache")
    public CacheProperties cacheProperties() {
        return new CacheProperties();
    }

    @Bean
    public SmartInitializingSingleton importProcessor() {
        return () -> LOGGER.debug("Smart Singleton triggered AFTER bean init but BEFORE ports open");
    }

    @EventListener(ApplicationReadyEvent.class)
    public void ready() {
        LOGGER.debug("ApplicationReadyEvent triggered very last");
    }

}
