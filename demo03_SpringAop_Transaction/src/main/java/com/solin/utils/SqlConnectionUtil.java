package com.solin.utils;


import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author solin
 * @Date 2021/8/24 22:37
 * @content
 */
@Component
public class SqlConnectionUtil {
    @Autowired
    private HikariDataSource dataSource;

    private ThreadLocal<Connection> threadLocal=new ThreadLocal<>();

    public Connection getConnection() throws SQLException {
        if (threadLocal.get()==null){
           Connection connection = dataSource.getConnection();
           threadLocal.set(connection);
           return connection;
        }
        return threadLocal.get();
    }
}
