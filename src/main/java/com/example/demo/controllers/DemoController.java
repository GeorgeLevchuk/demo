package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/task") //ip:port/task  localhost:8080/task
    public String task() {
        return "Hello World";
    }

    @PostMapping("/taskGet") //ip:port/taskGet  localhost:8080/taskGet
    public String taskGet() {
        return "Hello World";
    }
}
