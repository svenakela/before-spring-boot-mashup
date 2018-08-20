package com.trustly.robocops.logic.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.trustly.robocops.logic.CacheProperties;
import com.trustly.robocops.logic.CacheService;
import com.trustly.robocops.model.Robocop;

public class CacheServiceImpl implements CacheService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CacheServiceImpl.class);
    private final Map<String, Robocop> map = new ConcurrentHashMap<>();
    private final CacheProperties properties;

    public CacheServiceImpl(final CacheProperties props) {
        properties = props;
    }

    @Override
    public String save(final Robocop cop) {
        map.put(cop.getDeveloper(), cop);
        return cop.getDeveloper();
    }

    @Override
    public Robocop get(final String id) {
        return Optional.of(map.get(id)).orElseGet(Robocop::new);
    }

    @Override
    public List<Robocop> getAll() {
        LOGGER.debug("Someone requested all from cache. Max size is set to {}", properties.getMaxSize());
        return new ArrayList<>(map.values());
    }
}
