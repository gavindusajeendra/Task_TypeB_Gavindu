package com.typebdigital.hello_world_api.controller;

import com.typebdigital.hello_world_api.HelloWorldApiApplication;
import com.typebdigital.hello_world_api.service.HelloWorldService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {

    private final HelloWorldService service;

    public HelloWorldController(HelloWorldService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> hello(@RequestParam(required = false) String name) {
        return service.process(name);
    }
}