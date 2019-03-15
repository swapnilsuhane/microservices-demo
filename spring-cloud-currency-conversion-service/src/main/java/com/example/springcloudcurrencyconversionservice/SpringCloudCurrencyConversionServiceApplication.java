package com.example.springcloudcurrencyconversionservice;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients("com.example.springcloudcurrencyconversionservice")
@EnableDiscoveryClient
public class SpringCloudCurrencyConversionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudCurrencyConversionServiceApplication.class, args);
    }

    @Bean
    public Sampler defaultSampler(){
        return Sampler.ALWAYS_SAMPLE;
    }
}
