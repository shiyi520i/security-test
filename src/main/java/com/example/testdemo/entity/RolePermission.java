package com.example.testdemo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

 /**
  *${description}
  * @author     ：ShiYI
  * @date       ：Created in 2021/9/27
  */
@ApiModel(value="t_role_permission")
@Data
public class RolePermission {
    @ApiModelProperty(value="")
    private String roleId;

    @ApiModelProperty(value="")
    private String permissionId;
}