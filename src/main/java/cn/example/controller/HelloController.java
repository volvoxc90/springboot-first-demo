package cn.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhugp
 * @create 2018-03-09 14:54
 **/
@RestController
public class HelloController {


    @RequestMapping(value = "sayHello", method = RequestMethod.GET)
    public String sayHello() {
        return "SpringBoot hello2";
    }
}