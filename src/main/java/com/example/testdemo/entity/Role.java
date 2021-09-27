package com.example.testdemo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

 /**
  *${description}
  * @author     ：ShiYI
  * @date       ：Created in 2021/9/27
  */
@ApiModel(value="t_role")
@Data
public class Role {
    @ApiModelProperty(value="")
    private String id;

    @ApiModelProperty(value="")
    private String roleName;

    @ApiModelProperty(value="")
    private String description;

    @ApiModelProperty(value="")
    private Date createTime;

    @ApiModelProperty(value="")
    private Date updateTime;

    @ApiModelProperty(value="")
    private String status;
}