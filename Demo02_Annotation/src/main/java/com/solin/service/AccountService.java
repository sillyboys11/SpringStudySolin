package com.solin.service;

import com.solin.domain.AccountEntity;

/**
 * @Author solin
 * @Date 2021/8/19 22:46
 * @content
 */
public interface AccountService {
    int save(AccountEntity entity);

    AccountEntity findById(int id);
}
