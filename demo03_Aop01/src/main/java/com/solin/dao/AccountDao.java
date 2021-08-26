package com.solin.dao;

import com.solin.domain.AccountEntity;

/**
 * @Author solin
 * @Date 2021/8/23 22:09
 * @content
 */
public interface AccountDao {
    int saveAccount(AccountEntity accountEntity);

    AccountEntity findById(int id);

    void delById(int id);

    void update(String sendName, double mondy);
}
