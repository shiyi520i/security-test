package com.example.testdemo.server.impl;

import com.example.testdemo.entity.Permission;
import com.example.testdemo.server.PermissionService;
import com.example.testdemo.server.RolePermissionService;
import com.example.testdemo.server.UserRoleService;
import com.example.testdemo.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务类
 *
 * @author ：ShiYI
 * @date ：Created in 2021/9/22
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userServiceser;
    @Autowired
    private RolePermissionService rolePermissionService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private PermissionService permissionService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //获得用户名
        com.example.testdemo.entity.User user = userServiceser.findByUsername(s);
        //根据用户名寻找权限
       // Permission permission = permissionService.selectByPrimaryKey(rolePermissionService.findByRoleId(userRoleService.findByUserId(user.getId().toString()).getRoleId()).getPermissionId());
        List<String> permissions = permissionService.getAll(user.getId().toString());
        String[] perarray = new String[permissions.size()];
        permissions.toArray(perarray);
        if (user==null){return null;}else {
            UserDetails userDetails = User.withUsername(user.getUsername()).password(user.getPassword()).authorities(perarray).build();//permission.getCode()
            return userDetails;
        }
    }
}
