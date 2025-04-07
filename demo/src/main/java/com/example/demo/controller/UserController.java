package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户控制器
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    
    private final UserService userService;
    
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    /**
     * 用户注册
     * 
     * @param user 用户信息
     * @return 注册结果
     */
    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(@RequestBody User user) {
        Map<String, Object> result = new HashMap<>();
        
        boolean success = userService.register(user);
        if (success) {
            result.put("success", true);
            result.put("message", "注册成功");
            result.put("data", user);
        } else {
            result.put("success", false);
            result.put("message", "注册失败，用户名可能已存在");
        }
        
        return ResponseEntity.ok(result);
    }
    
    /**
     * 用户登录
     * 
     * @param loginForm 登录表单
     * @return 登录结果
     */
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> loginForm) {
        Map<String, Object> result = new HashMap<>();
        
        String username = loginForm.get("username");
        String password = loginForm.get("password");
        
        User user = userService.login(username, password);
        if (user != null) {
            result.put("success", true);
            result.put("message", "登录成功");
            result.put("data", user);
        } else {
            result.put("success", false);
            result.put("message", "登录失败，用户名或密码错误");
        }
        
        return ResponseEntity.ok(result);
    }
    
    /**
     * 获取用户信息
     * 
     * @param id 用户ID
     * @return 用户信息
     */
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getUserById(@PathVariable Long id) {
        Map<String, Object> result = new HashMap<>();
        
        User user = userService.getUserById(id);
        if (user != null) {
            result.put("success", true);
            result.put("data", user);
        } else {
            result.put("success", false);
            result.put("message", "用户不存在");
        }
        
        return ResponseEntity.ok(result);
    }
    
    /**
     * 获取所有用户
     * 
     * @return 用户列表
     */
    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getAllUsers() {
        Map<String, Object> result = new HashMap<>();
        
        List<User> users = userService.getAllUsers();
        result.put("success", true);
        result.put("data", users);
        
        return ResponseEntity.ok(result);
    }
} 