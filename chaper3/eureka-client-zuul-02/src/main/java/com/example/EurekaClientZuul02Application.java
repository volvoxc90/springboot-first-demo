package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClientZuul02Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientZuul02Application.class, args);
	}
}
