package com.example.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhugp
 * @create 2018-04-04 15:12
 **/
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "sayHelloError")
    public String sayHello(@RequestParam(value = "name") String name) {
        return restTemplate.getForObject("http://service-client/home?name=" + name, String.class);

    }

    public String sayHelloError(String name) {
        return "Execute me " + name + ", connection error";
    }
}