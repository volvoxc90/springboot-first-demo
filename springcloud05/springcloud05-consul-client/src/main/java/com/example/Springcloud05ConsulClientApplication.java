package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Springcloud05ConsulClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springcloud05ConsulClientApplication.class, args);
	}
}
