package com.example.testdemo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

 /**
  *${description}
  * @author     ：ShiYI
  * @date       ：Created in 2021/9/27
  */
@ApiModel(value="t_permission")
@Data
public class Permission {
    @ApiModelProperty(value="")
    private String id;

    /**
    * 权限标识符
    */
    @ApiModelProperty(value="权限标识符")
    private String code;

    /**
    * 描述
    */
    @ApiModelProperty(value="描述")
    private String description;

    /**
    * 请求地址
    */
    @ApiModelProperty(value="请求地址")
    private String url;
}