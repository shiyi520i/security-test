package com.example.testdemo.controller;

import com.example.testdemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据控制类
 *
 * @author ：ShiYI
 * @date ：Created in 2021/9/24
 */
@RestController
public class DataController {
    @Autowired
    private com.example.testdemo.server.UserService UserService;

    @RequestMapping("/test")
    public User getD(){
        //return tUserService.selectByPrimaryKey(Long.valueOf(1));
        //return tUserService.findByUsername("张三");
        return UserService.findByUsername("张三");
    }

    @RequestMapping("/testjpg")
    public String getJpg() {
        return "/img/a.png";
    }

    @RequestMapping("/success")
    public String toSucccess() {
        return "登录成功";
    }
}
