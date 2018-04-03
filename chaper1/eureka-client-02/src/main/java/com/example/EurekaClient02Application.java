package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClient02Application {

    /*@Bean
    CommandLineRunner runner(DiscoveryClient discoveryClient) {
        return args -> {
            discoveryClient.getInstances("eureka-client-01").forEach(si -> System.out.println(String.format("Found %s %s : %s", si.getServiceId(), si.getHost(), si.getPort())));
        };
    }*/

    public static void main(String[] args) {
        SpringApplication.run(EurekaClient02Application.class, args);
    }
}
