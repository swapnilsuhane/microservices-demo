package com.example.springcloudlimitservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class SpringCloudLimitServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudLimitServiceApplication.class, args);
    }
}
