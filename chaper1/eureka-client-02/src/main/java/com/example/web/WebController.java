package com.example.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhugp
 * @create 2018-04-02 17:36
 **/
@RestController
public class WebController {


    @Value("${server.port}")
    String port;
    @RequestMapping("/home")
    public String home(@RequestParam String name) {
        return "hello " + name + ", " + port;

    }
}