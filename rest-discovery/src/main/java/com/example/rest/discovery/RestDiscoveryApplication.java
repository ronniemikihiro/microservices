package com.example.rest.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RestDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestDiscoveryApplication.class, args);
	}

}
