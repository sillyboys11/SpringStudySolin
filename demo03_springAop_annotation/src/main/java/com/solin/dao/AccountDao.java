package com.solin.dao;

import com.solin.domain.AccountEntity;

/**
 * @Author solin
 * @Date 2021/8/24 22:23
 * @content
 */
public interface AccountDao {
    int delById(int id);

    int save(AccountEntity entity);

    AccountEntity selectById(int id);

    int update(String name, double money);
}
