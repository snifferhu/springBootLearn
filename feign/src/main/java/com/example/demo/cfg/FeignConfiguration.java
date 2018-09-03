package com.example.demo.cfg;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @auth snifferhu
 * @date 2018/4/1 10:14
 */
//@Configuration
public class FeignConfiguration {
//    @Bean
//    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }
}
