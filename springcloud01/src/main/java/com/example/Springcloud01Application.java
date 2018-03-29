package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class Springcloud01Application {

    public static void main(String[] args) {
//        SpringApplication springApplication = new SpringApplication(Springcloud01Application.class);
//
//        ConfigurableEnvironment configurableEnvironment = new C
//
//        springApplication.setEnvironment(true);
//        springApplication.run(args);
        SpringApplication.run(Springcloud01Application.class, args);
    }
}
