package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * 用户服务实现类
 */
@Service
public class UserServiceImpl implements UserService {
    
    private final UserMapper userMapper;
    
    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    
    @Override
    public boolean register(User user) {
        // 检查用户名是否已存在
        User existingUser = userMapper.selectByUsername(user.getUsername());
        if (existingUser != null) {
            return false;
        }
        
        // 设置用户默认状态为正常
        user.setStatus(1);
        
        // 插入用户
        int result = userMapper.insert(user);
        return result > 0;
    }
    
    @Override
    public User login(String username, String password) {
        User user = userMapper.selectByUsername(username);
        if (user != null && Objects.equals(user.getPassword(), password)) {
            return user;
        }
        return null;
    }
    
    @Override
    public User getUserById(Long id) {
        return userMapper.selectById(id);
    }
    
    @Override
    public User getUserByUsername(String username) {
        return userMapper.selectByUsername(username);
    }
    
    @Override
    public List<User> getAllUsers() {
        return userMapper.selectAll();
    }
} 