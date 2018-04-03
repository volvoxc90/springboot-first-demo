package com.example.web;

import com.example.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhugp
 * @create 2018-04-03 15:29
 **/
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @Value("${server.port}")
    String port;

    @RequestMapping("/home")
    public String home(@RequestParam String name) {
        return helloService.home(name);
    }

}