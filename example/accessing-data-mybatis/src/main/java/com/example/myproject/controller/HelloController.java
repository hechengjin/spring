package com.example.myproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hechengjin on 17-8-1.
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) throws Exception {
        int x = 5/0;
        return "hello " + name;
    }
}
