package com.trustly.robocops.resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trustly.robocops.model.Robocop;

@RestController
@RequestMapping("/v1")
public class MyLittleRest {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping(value="/robocop/{name}", produces="application/json")
    public Robocop getRobo(@PathVariable final String name) {
        return new Robocop(name, "El Banco", Robocop.Language.JAVA);
    }




}
