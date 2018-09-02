package com.example.demo.web;

import com.example.demo.service.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @auth snifferhu
 * @date 2018/3/30 21:31
 */
@RestController("/")
public class SimpleController {
    @Autowired
    private SimpleService simpleService;

    @GetMapping(value = "/add")
    public String add() {
        return simpleService.add();
    }

    @RequestMapping("/")
    public String hello() {
        return simpleService.home();
    }


    @RequestMapping("/greeting")
    public String greet() {
        return simpleService.greet();
    }
}
