package com.example.testdemo.server;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.testdemo.mapper.RolePermissionMapper;
import com.example.testdemo.entity.RolePermission;

import java.util.List;

/**
  *${description}
  * @author     ：ShiYI
  * @date       ：Created in 2021/9/27
  */
@Service
public class RolePermissionService{

    @Resource
    private RolePermissionMapper rolePermissionMapper;

    
    public int deleteByPrimaryKey(String roleId,String permissionId) {
        return rolePermissionMapper.deleteByPrimaryKey(roleId,permissionId);
    }

    
    public int insert(RolePermission record) {
        return rolePermissionMapper.insert(record);
    }

    
    public int insertSelective(RolePermission record) {
        return rolePermissionMapper.insertSelective(record);
    }

    public RolePermission findByRoleId(String rop){
        List<RolePermission> rolePermissions = rolePermissionMapper.findByRoleId(rop);
        return rolePermissions.get(0);
    }

}
