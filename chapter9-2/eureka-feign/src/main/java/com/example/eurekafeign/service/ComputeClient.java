package com.example.eurekafeign.service;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhugp
 * @create 2018-03-24 14:02
 **/
@FeignClient("compute-service")

public interface ComputeClient {

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

}