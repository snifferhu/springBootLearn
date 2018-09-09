package com.example.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @auth snifferhu
 * @date 2018/4/1 11:21
 */
//@FeignClient(value = "simple", fallback = SimpleServiceFallback.class)
public interface SimpleService {
    @GetMapping(value = "/")
    String home();

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    String add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

    @GetMapping(value = "/greeting")
    String greet();
}