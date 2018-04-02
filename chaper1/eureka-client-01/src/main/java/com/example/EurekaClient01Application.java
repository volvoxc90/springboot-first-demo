package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClient01Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClient01Application.class, args);
	}
}
