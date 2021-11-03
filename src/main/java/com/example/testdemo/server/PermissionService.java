package com.example.testdemo.server;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.testdemo.entity.Permission;
import com.example.testdemo.mapper.PermissionMapper;

import java.util.List;

/**
  *${description}
  * @author     ：ShiYI
  * @date       ：Created in 2021/9/27
  */
@Service
public class PermissionService{

    @Resource
    private PermissionMapper permissionMapper;

    
    public int deleteByPrimaryKey(String id) {
        return permissionMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(Permission record) {
        return permissionMapper.insert(record);
    }

    
    public int insertSelective(Permission record) {
        return permissionMapper.insertSelective(record);
    }

    
    public Permission selectByPrimaryKey(String id) {
        return permissionMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(Permission record) {
        return permissionMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Permission record) {
        return permissionMapper.updateByPrimaryKey(record);
    }

    public List<String> getAll(String id){return permissionMapper.getAll(id);}

}
