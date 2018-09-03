package com.example.demo.client;

import com.example.demo.service.SimpleService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @auth snifferhu
 * @date 2018/4/1 11:20
 */
@FeignClient(value = "simple")
public interface SimpleClient extends SimpleService {

}
