package com.example.testdemo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

 /**
  *${description}
  * @author     ：ShiYI
  * @date       ：Created in 2021/9/27
  */
@ApiModel(value="t_user")
@Data
public class User {
    /**
    * 用户id
    */
    @ApiModelProperty(value="用户id")
    private Long id;

    @ApiModelProperty(value="")
    private String username;

    @ApiModelProperty(value="")
    private String password;

    /**
    * 用户姓名
    */
    @ApiModelProperty(value="用户姓名")
    private String fullname;

    /**
    * 手机号
    */
    @ApiModelProperty(value="手机号")
    private String mobile;
}