package com.example.testdemo.server;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.testdemo.entity.User;
import com.example.testdemo.mapper.UserMapper;

import java.util.List;

/**
  *${description}
  * @author     ：ShiYI
  * @date       ：Created in 2021/9/27
  */
@Service
public class UserService{

    @Resource
    private UserMapper userMapper;

    
    public int deleteByPrimaryKey(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(User record) {
        return userMapper.insert(record);
    }

    
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    
    public User selectByPrimaryKey(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    public User findByUsername(String username){
        List<User> users = userMapper.findByUsername(username);
        if(users == null && users.size() <= 0){ return null; }
        else {return users.get(0);}
    }

}
