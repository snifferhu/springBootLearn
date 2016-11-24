package com.demo.service.impl;

import com.demo.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

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
        logger.debug("This is a debug message 你大爷");
        logger.info("This is an info message 你大爷");
        logger.warn("This is a warn message 你大爷");
        logger.error("This is an error message 你大爷");
        logger.error(String.valueOf(new IOException()));
        return "hello " + who() + testService.doSomeThing();
    }

    abstract String who();
}
