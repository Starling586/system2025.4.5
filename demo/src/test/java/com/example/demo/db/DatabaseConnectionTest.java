package com.example.demo.db;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class DatabaseConnectionTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void testDatabaseConnection() throws SQLException {
        assertNotNull(dataSource, "数据源不应该为空");
        
        Connection connection = dataSource.getConnection();
        assertNotNull(connection, "应该能够获取连接");
        
        assertTrue(connection.isValid(1), "连接应该有效");
        
        System.out.println("数据库连接成功!");
        System.out.println("连接URL: " + connection.getMetaData().getURL());
        System.out.println("数据库产品名称: " + connection.getMetaData().getDatabaseProductName());
        System.out.println("数据库产品版本: " + connection.getMetaData().getDatabaseProductVersion());
        
        connection.close();
    }
} 