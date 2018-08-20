package com.trustly.robocops;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.trustly.robocops.logic.CacheProperties;
import com.trustly.robocops.logic.CacheService;
import com.trustly.robocops.logic.impl.CacheServiceImpl;
import com.trustly.robocops.resource.RobocopSinglePointController;

@Configuration
public class MyLittleConfig {

    @Bean
    public RobocopSinglePointController rspc(final CacheService cache, final CacheProperties props) {
        return new RobocopSinglePointController(cache);
    }

    @Bean
    public CacheService robocopCache(final CacheProperties properties) {
        return new CacheServiceImpl(properties);
    }

}
