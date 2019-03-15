package com.example.springcloudlimitservice;

import com.example.springcloudlimitservice.bean.LimitConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitConfigurationController {
    @Autowired
    Configuration configuration;

    @GetMapping("/limits")
    public LimitConfiguration retrieveLimitsFromConfigurations(){
        return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
    }

    @GetMapping("/fault-tolerance-example")
    @HystrixCommand(fallbackMethod = "faultToleranceretrieve")
    public LimitConfiguration retrieve(){
        throw new RuntimeException("Not Available");
    }

    public LimitConfiguration faultToleranceretrieve(){
        return new LimitConfiguration(9, 9999);
    }
}
