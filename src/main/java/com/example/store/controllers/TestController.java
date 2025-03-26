package com.example.store.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/test")
public class TestController {
    @GetMapping
    public String test() {
        return "Hello World";
    }
}
