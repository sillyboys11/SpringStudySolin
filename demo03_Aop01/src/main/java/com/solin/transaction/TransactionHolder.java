package com.solin.transaction;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 获取连接
 */
@Component
public class TransactionHolder {
   private ThreadLocal<Connection> threadLocal=new ThreadLocal<>();

    @Autowired
    private HikariDataSource dataSource;

    public Connection getConnection() throws SQLException {
        if (threadLocal.get()==null){
            Connection connection = dataSource.getConnection();
            threadLocal.set(connection);
            return connection;
        }
        return threadLocal.get();
    }
}
