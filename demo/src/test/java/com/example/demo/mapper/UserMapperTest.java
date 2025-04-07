package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testSelectAll() {
        List<User> users = userMapper.selectAll();
        System.out.println("查询到的用户数量: " + users.size());
        users.forEach(System.out::println);
    }
} 