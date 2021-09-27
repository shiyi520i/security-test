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
@ApiModel(value="t_user_role")
@Data
public class UserRole {
    @ApiModelProperty(value="")
    private String userId;

    @ApiModelProperty(value="")
    private String roleId;

    @ApiModelProperty(value="")
    private Date createTime;

    @ApiModelProperty(value="")
    private String creator;
}