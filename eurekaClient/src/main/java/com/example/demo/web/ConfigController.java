package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController("/config")
public class ConfigController {
    @Autowired
    private Environment env;

    @GetMapping
    public String getConfig(@RequestParam String key){
        return env.getProperty(key);
    }
}
