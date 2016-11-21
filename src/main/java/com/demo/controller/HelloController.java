package com.demo.controller;

/**
 * Created by Sniff on 2016/11/2.
 */

import com.demo.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RestController
public class HelloController {
    @Autowired
    Map<String, Service> router;

    @RequestMapping("/")
    public String index() {
        return router.get("GET").doSomeThing();
    }

}