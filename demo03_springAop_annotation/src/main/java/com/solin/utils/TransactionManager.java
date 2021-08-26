package com.solin.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author solin
 * @Date 2021/8/24 22:42
 * @content
 */
@Component
@Aspect
public class TransactionManager {
    @Autowired
    private SqlConnectionUtil sqlConnectionUtil;

    //开启
    public void start() throws SQLException {
        sqlConnectionUtil.getConnection().setAutoCommit(false);
    }

    public void commit() throws SQLException {
        sqlConnectionUtil.getConnection().commit();
    }

    public void rollBack() {
        try {
            sqlConnectionUtil.getConnection().rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        try {
            Connection connection = sqlConnectionUtil.getConnection();
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Around("execution(* com.solin.service.impl.*.*(..))")
    public Object aroundTransaction(ProceedingJoinPoint joinPoint) {
        try {
            //开启事务
            start();
            System.out.println("开启事务");
            //调用切入点的方法
            Object o = joinPoint.proceed();
            commit();
            System.out.println("提交事务");
            return o;
        } catch (Throwable throwable) {
            rollBack();
            System.out.println("回滚事务");
            throw new RuntimeException(throwable);
        } finally {
            close();
            System.out.println("关闭连接");
        }
    }
}
