package com.example.eurekafeign.service;

import org.springframework.stereotype.Service;

/**
 * @author zhugp
 * @create 2018-03-26 16:07
 **/
@Service
public class ComputeClientImpl implements ComputeClient  {
    @Override
    public Integer add(Integer a, Integer b) {
        return a + b;
    }
}