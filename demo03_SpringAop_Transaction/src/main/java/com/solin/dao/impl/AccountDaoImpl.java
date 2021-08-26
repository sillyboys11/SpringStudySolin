package com.solin.dao.impl;

import com.solin.dao.AccountDao;
import com.solin.domain.AccountEntity;
import com.solin.utils.SqlConnectionUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

/**
 * @Author solin
 * @Date 2021/8/24 22:24
 * @content
 */
@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private QueryRunner queryRunner;

    @Autowired
    private SqlConnectionUtil sqlConnectionUtil;
    @Override
    public int delById(int id) {
        return 0;
    }


    @Override
    public int save(AccountEntity entity) {
        return 0;
    }

    @Override
    public int update(String name, double money) {
        String sql="update tr_account set money=money+? where name=?";
        try {
            return queryRunner.update(sqlConnectionUtil.getConnection(),sql,money,name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public AccountEntity selectById(int id) {
        String sql="select * from tr_account where id=?";
        try {
            AccountEntity query = queryRunner.query(sqlConnectionUtil.getConnection(),sql, new BeanHandler<>(AccountEntity.class), id);
            return query;
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
    }
}
