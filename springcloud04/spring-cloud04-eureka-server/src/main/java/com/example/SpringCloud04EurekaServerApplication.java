package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer    //激活注册中心
//@EnableDiscoveryClient
public class SpringCloud04EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloud04EurekaServerApplication.class, args);
	}
}
