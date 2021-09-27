package com.example.testdemo.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * excel文件控制
 *
 * @author ：ShiYI
 * @date ：Created in 2021/9/6
 */
@Api
@RestController
public class ExcelController {
     @GetMapping("/a")
     public String a(String a){
       return "a";

      }

}
