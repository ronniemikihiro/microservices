package com.example.rest.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class RestGatewayApplication {

    public static void main(final String[] args) {
        SpringApplication.run((Class) RestGatewayApplication.class, args);
    }

}
