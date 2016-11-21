package com.demo.service.impl;

/**
 * Created by Sniff on 2016/11/2.
 */
@org.springframework.stereotype.Service("GET")
public class GetService extends BaseService {

    @Override
    String who() {
        return "world!";
    }
}
