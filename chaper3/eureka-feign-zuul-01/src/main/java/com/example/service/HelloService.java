package com.example.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhugp
 * @create 2018-04-04 17:44
 **/
@FeignClient(value = "service-feign")
public interface HelloService {
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    String sayHello(@RequestParam(value = "name") String name);
}