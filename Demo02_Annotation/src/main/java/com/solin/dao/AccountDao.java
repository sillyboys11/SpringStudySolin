package com.solin.dao;

import com.solin.domain.AccountEntity;

/**
 * @Author solin
 * @Date 2021/8/19 22:47
 * @content
 */
public interface AccountDao {
    int save(AccountEntity entity);

    AccountEntity findById(int id);
}
