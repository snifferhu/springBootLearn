package com.demo.service.impl;

import com.demo.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Sniff on 2016/11/3.
 */
public abstract class BaseService implements Service {
    private static final Logger logger = LoggerFactory.getLogger(BaseService.class);
    @Autowired
    TestService testService;

    @Override
    public String doSomeThing() {
        logger.info("test {}", System.currentTimeMillis());
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        return "hello " + who() + testService.doSomeThing();
    }

    abstract String who();
}
