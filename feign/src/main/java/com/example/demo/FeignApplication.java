package com.example.demo;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableFeignClients
public class FeignApplication {
	@Autowired
	Simple client;

	@RequestMapping("/")
	public String hello() {
		return client.home();
	}

	@RequestMapping("/add")
	public String add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
		return client.add(a,b);
	}

	@RequestMapping("/greeting")
	public String greet() {
		return client.greet();
	}

	public static void main(String[] args) {
		SpringApplication.run(FeignApplication.class, args);
	}

	@FeignClient("simple")
	interface Simple {
		@GetMapping(value = "/")
		String home();

		@GetMapping(value = "/add")
		String add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

		@GetMapping(value = "/greeting")
		String greet();
	}
}
