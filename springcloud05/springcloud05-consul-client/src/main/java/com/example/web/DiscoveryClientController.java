package com.example.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhugp
 * @create 2018-03-29 17:52
 **/
@RestController
public class DiscoveryClientController {

    private final DiscoveryClient discoveryClient;

    private final String currentApplicationName;

    public DiscoveryClientController(DiscoveryClient discoveryClient,@Value("${spring.application.name}")
            String currentApplicationName) {
        this.discoveryClient = discoveryClient;
        this.currentApplicationName = currentApplicationName;
    }



    @GetMapping("/current/service-instance")
    public List<String> getCurrentServiceInstance() {
        return discoveryClient.getServices();
    }
}