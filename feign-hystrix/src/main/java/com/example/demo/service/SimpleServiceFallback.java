package com.example.demo.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class SimpleServiceFallback implements SimpleService {

    @Override
    public String home() {
        return "fallback";
    }

    @Override
    public String add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        return "fallback";
    }

    @Override
    public String greet() {
        return "fallback";
    }
}