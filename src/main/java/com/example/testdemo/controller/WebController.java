package com.example.testdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 网页控制类
 *
 * @author ：ShiYI
 * @date ：Created in 2021/9/17
 */
@Controller
public class WebController {
    @GetMapping("/")
    public String webOne(){
        return "knaban";
    }
    @GetMapping("/test2")
    public String webTwo(){
        return "test2";
    }

    @RequestMapping("/test3")
    public String webTree(){
        return "test3";
    }
}
