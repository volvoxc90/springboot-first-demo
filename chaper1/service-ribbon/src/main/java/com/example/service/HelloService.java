package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhugp
 * @create 2018-04-03 15:29
 **/
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    public String home(String name) {
        return restTemplate.getForObject("http://eureka-client-01/home?name=" + name, String.class);
    }
}