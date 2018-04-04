package com.example.service;

import org.springframework.stereotype.Component;

/**
 * @author zhugp
 * @create 2018-04-04 17:46
 **/
@Component
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "Execute me, "  + name;
    }
}