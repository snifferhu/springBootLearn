package com.demo.service.impl;

import com.demo.service.Service;

/**
 * Created by Sniff on 2016/11/3.
 */
@org.springframework.stereotype.Service
public class TestService implements Service {
    @Override
    public String doSomeThing() {
        return " test";
    }
}
