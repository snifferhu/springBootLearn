package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaClient;

/**
 * Created by Sniff on 2016/10/29.
 */
@SpringBootApplication
@EnableScheduling
@EnableEurekaClient
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        logger.info("starting spring boot ...");
        SpringApplication.run(Application.class, args);
        logger.info("everything is started.");
    }
}