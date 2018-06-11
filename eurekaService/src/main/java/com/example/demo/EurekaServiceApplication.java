package com.example.demo;

import com.example.model.qo.UsersMerchantsQo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.*;

@EnableEurekaServer
@SpringBootApplication
@RestController
public class EurekaServiceApplication {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceApplication.class, args);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        Integer r = a + b;
        return r;
    }

    @PostMapping(value = "test")
    public String test(@ModelAttribute UsersMerchantsQo qo) {
        logger.info("{}", qo);
        return "ok";
    }
}
