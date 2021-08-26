package com.solin.dao.impl;

import com.solin.dao.AccountDao;
import com.solin.domain.AccountEntity;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

/**
 * @Author solin
 * @Date 2021/8/19 22:47
 * @content @Repository--持久层  和 @component 一样
 */
@Repository
public class AccountDaoImpl implements AccountDao {
    //获取容器的QueryRunner
    @Autowired
    private QueryRunner queryRunner;

    @Override
    public int save(AccountEntity entity) {
        String sql = "insert into tr_account values(null,?,?)";
        try {
            return queryRunner.update(sql, entity.getName(), entity.getMoney());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public AccountEntity findById(int id) {
        String sql = "select * from tr_account where id=?";
        try {
            AccountEntity entity = queryRunner.query(sql, new BeanHandler<>(AccountEntity.class), id);
            return entity;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
