package com.example.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhugp
 * @create 2018-03-30 10:27
 **/
@RestController
public class CheckController {
    @GetMapping("/check")
    public String check() {
        return "OK";
    }
}