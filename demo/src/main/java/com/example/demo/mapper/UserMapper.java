package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户Mapper接口
 */
@Mapper
public interface UserMapper {
    
    /**
     * 根据ID查询用户
     * 
     * @param id 用户ID
     * @return 用户实体
     */
    @Select("SELECT * FROM user WHERE id = #{id} AND is_deleted = 0")
    User selectById(Long id);
    
    /**
     * 根据用户名查询用户
     * 
     * @param username 用户名
     * @return 用户实体
     */
    @Select("SELECT * FROM user WHERE username = #{username} AND is_deleted = 0")
    User selectByUsername(String username);
    
    /**
     * 查询所有用户
     * 
     * @return 用户列表
     */
    @Select("SELECT * FROM user WHERE is_deleted = 0")
    List<User> selectAll();
    
    /**
     * 插入用户
     * 
     * @param user 用户信息
     * @return 影响的行数
     */
    @Insert("INSERT INTO user (username, password, email, phone, status) VALUES (#{username}, #{password}, #{email}, #{phone}, #{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(User user);
} 