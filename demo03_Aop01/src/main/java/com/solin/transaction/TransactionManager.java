package com.solin.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author solin
 * @Date 2021/8/23 22:57
 * @content 事务管理器
 */
@Component
public class TransactionManager {
    @Autowired
    public TransactionHolder holder;

    public void startTransaction() throws SQLException {
        holder.getConnection().setAutoCommit(false);
    }

    public void commitTransaction() throws SQLException {
        holder.getConnection().commit();
    }

    public void rollBackTransaction(){
        try {
            holder.getConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeTransaction(){
        try {
            Connection connection = holder.getConnection();
            if (connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
