package com.trustly.robocops.logic;

import java.util.List;

import com.trustly.robocops.model.Robocop;

public interface CacheService {

    public String save(final Robocop cop);

    public Robocop get(final String id);

    public List<Robocop> getAll();
}
