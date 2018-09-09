package com.example.demo.web;

import com.example.demo.service.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {
    @Autowired
    SimpleService service;

    @RequestMapping("/")
    public String hello() {
        return service.home();
    }

    @RequestMapping("/add")
    public String add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        return service.add(a,b);
    }

    @RequestMapping("/greeting")
    public String greet() {
        return service.greet();
    }
}
