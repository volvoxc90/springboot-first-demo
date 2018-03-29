package com.example.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhugp
 * @create 2018-03-27 17:27
 **/
@RestController
public class StatusController {

    @GetMapping("/status")
    public String status() {
        return "OK";
    }
}