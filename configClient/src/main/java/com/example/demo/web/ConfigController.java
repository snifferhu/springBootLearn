package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigController {
    @Autowired
    private Environment env;

    @RequestMapping("/config")
    public String getConfig(@RequestParam String key){
        return env.getProperty(key,"undefined");
    }
}
