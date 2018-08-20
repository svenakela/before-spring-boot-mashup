package com.trustly.robocops.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trustly.robocops.logic.CacheService;
import com.trustly.robocops.model.Robocop;

@ResponseBody
@RequestMapping("/v2/robocop")
public class RobocopSinglePointController {

    private final CacheService cache;

    public RobocopSinglePointController(final CacheService cacheService) {
        cache = cacheService;
    }

    @PostMapping
    public ResponseEntity<String> addRobo(@RequestBody final Robocop cop) {
        cache.save(cop);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public List<Robocop> getAllRobocops() {
        return cache.getAll();
    }

    @GetMapping("/{name}")
    public Robocop getRobo(@PathVariable final String name) {
        return new Robocop(name, "El Banco", Robocop.Language.JAVA);
    }
}
