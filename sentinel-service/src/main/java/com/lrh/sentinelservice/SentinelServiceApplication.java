package com.lrh.sentinelservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SentinelServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinelServiceApplication.class,args);
    }

}
