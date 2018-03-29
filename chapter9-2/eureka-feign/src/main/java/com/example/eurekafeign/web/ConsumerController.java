package com.example.eurekafeign.web;

import com.example.eurekafeign.service.ComputeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhugp
 * @create 2018-03-24 14:07
 **/
@RestController

public class ConsumerController {

    @Autowired
    ComputeClient computeClient;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public Integer add() {
        return computeClient.add(10, 20);
    }

}