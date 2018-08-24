package com.trustly.robocops.logic;

import java.nio.file.Path;
import java.time.Duration;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;

@Validated
public class CacheProperties {

    private int timeoutMs = 10000;

    @Min(10)
    @Max(65536)
    private int maxSize = 100;

    public static class Redundancy {

        @NotEmpty
        private Path fileName;

        private Duration saveInterval;

        public Path getFileName() {
            return fileName;
        }

        public void setFileName(final Path fileName) {
            this.fileName = fileName;
        }

        public Duration getSaveInterval() {
            return saveInterval;
        }

        public void setSaveInterval(final Duration saveInterval) {
            this.saveInterval = saveInterval;
        }
    }

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
