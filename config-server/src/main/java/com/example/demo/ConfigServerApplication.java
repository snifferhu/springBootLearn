package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

	public static void main(String[] args) {
//		SpringApplication.run(ConfigServerApplication.class, args);
		new SpringApplicationBuilder(ConfigServerApplication.class).web(true).run(args);
	}
}
