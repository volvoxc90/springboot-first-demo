package com.example.web;

import com.example.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhugp
 * @create 2018-04-04 10:30
 **/
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String sayHello(@RequestParam String name) {
        return helloService.sayHello(name);
    }
}