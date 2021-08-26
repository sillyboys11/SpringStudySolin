package com.solin.dao.impl;

import com.solin.dao.AccountDao;
import com.solin.domain.AccountEntity;
import com.solin.transaction.TransactionHolder;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

/**
 * @Author solin
 * @Date 2021/8/23 22:10
 * @content
 */
@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private QueryRunner queryRunner;

    @Autowired
    private TransactionHolder holder;
    @Override
    public int saveAccount(AccountEntity accountEntity) {
        return 0;
    }

    @Override
    public AccountEntity findById(int id) {
        String sql="select * from tr_account where id=?";
        try {
            return queryRunner.query(sql, new BeanHandler<>(AccountEntity.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delById(int id) {

    }

    @Override
    public void update(String name, double mondy) {
        String sql="update tr_account  set money=money+? where name=?";
        try {
            int update = queryRunner.update(holder.getConnection(),sql, mondy, name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
