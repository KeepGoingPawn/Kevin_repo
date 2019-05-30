package com.example.demo.controller;

/**
 * @Author:Kevin
 * @Description:
 * @Date: 2019/5/30 15:48
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "Hello Spring Boot!";
    }
}
