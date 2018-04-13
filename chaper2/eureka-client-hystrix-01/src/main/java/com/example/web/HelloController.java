package com.example.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author zhugp
 * @create 2018-04-04 14:36
 **/
@RestController
public class HelloController {

    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String sayHello(@RequestParam(value = "name") String name) {


        return "hello, " + name + ", " + port;
    }

    public static void main(String[] args) {
        Collection collection = new ArrayList();
        for (int i = 0; i < 9; i++) {
            collection.add("宝马x" + i);
        }
        System.out.println(collection);
    }
}