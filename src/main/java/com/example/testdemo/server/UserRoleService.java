package com.example.testdemo.server;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.testdemo.mapper.UserRoleMapper;
import com.example.testdemo.entity.UserRole;

import java.util.List;

/**
  *${description}
  * @author     ：ShiYI
  * @date       ：Created in 2021/9/27
  */
@Service
public class UserRoleService{

    @Resource
    private UserRoleMapper userRoleMapper;

    
    public int deleteByPrimaryKey(String userId,String roleId) {
        return userRoleMapper.deleteByPrimaryKey(userId,roleId);
    }

    
    public int insert(UserRole record) {
        return userRoleMapper.insert(record);
    }

    
    public int insertSelective(UserRole record) {
        return userRoleMapper.insertSelective(record);
    }

    
    public UserRole selectByPrimaryKey(String userId,String roleId) {
        return userRoleMapper.selectByPrimaryKey(userId,roleId);
    }

    
    public int updateByPrimaryKeySelective(UserRole record) {
        return userRoleMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(UserRole record) {
        return userRoleMapper.updateByPrimaryKey(record);
    }

    public UserRole findByUserId(String userId){
        List<UserRole> userRoles = userRoleMapper.findByUserId(userId);
        return userRoles.get(0);
    }

}
