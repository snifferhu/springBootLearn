package com.demo.service.impl;

import com.demo.service.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Sniff on 2016/11/3.
 */
public abstract class BaseService implements Service {
    @Autowired
    TestService testService;

    @Override
    public String doSomeThing() {
        return "hello " + who() + testService.doSomeThing();
    }

    abstract String who();
}
