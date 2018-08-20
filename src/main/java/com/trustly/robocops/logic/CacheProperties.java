package com.trustly.robocops.logic;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "trustly.robocops.cache")
public class CacheProperties {

    private int timeoutMs = 10000;

    @Min(10)
    @Max(65536)
    private int maxSize = 100;

    public int getTimeoutMs() {
        return timeoutMs;
    }

    public void setTimeoutMs(final int timeoutMs) {
        this.timeoutMs = timeoutMs;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(final int maxSize) {
        this.maxSize = maxSize;
    }

}
