package com.example.testdemo.server;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.testdemo.entity.Role;
import com.example.testdemo.mapper.RoleMapper;
 /**
  *${description}
  * @author     ：ShiYI
  * @date       ：Created in 2021/9/27
  */
@Service
public class RoleService{

    @Resource
    private RoleMapper roleMapper;

    
    public int deleteByPrimaryKey(String id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(Role record) {
        return roleMapper.insert(record);
    }

    
    public int insertSelective(Role record) {
        return roleMapper.insertSelective(record);
    }

    
    public Role selectByPrimaryKey(String id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(Role record) {
        return roleMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Role record) {
        return roleMapper.updateByPrimaryKey(record);
    }

}
