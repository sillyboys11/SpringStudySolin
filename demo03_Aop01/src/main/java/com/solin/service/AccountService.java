package com.solin.service;

import com.solin.domain.AccountEntity;

/**
 * @Author solin
 * @Date 2021/8/23 22:09
 * @content
 */
public interface AccountService {
    int saveAccount(AccountEntity accountEntity);

    AccountEntity findById(int id);

    void delById(int id);

    void transaction(String sendName,String receiveName,double mondy);
}
