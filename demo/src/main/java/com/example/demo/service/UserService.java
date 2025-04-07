package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

/**
 * 用户服务接口
 */
public interface UserService {
    
    /**
     * 用户注册
     * 
     * @param user 用户信息
     * @return 注册成功返回true，否则返回false
     */
    boolean register(User user);
    
    /**
     * 用户登录
     * 
     * @param username 用户名
     * @param password 密码
     * @return 登录成功返回用户信息，否则返回null
     */
    User login(String username, String password);
    
    /**
     * 根据ID查询用户
     * 
     * @param id 用户ID
     * @return 用户信息
     */
    User getUserById(Long id);
    
    /**
     * 根据用户名查询用户
     * 
     * @param username 用户名
     * @return 用户信息
     */
    User getUserByUsername(String username);
    
    /**
     * 查询所有用户
     * 
     * @return 用户列表
     */
    List<User> getAllUsers();
} 