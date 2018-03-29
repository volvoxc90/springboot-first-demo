package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Springcloud05EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springcloud05EurekaServerApplication.class, args);
	}
}
