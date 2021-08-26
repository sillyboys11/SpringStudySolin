package com.solin.service;

import com.solin.domain.AccountEntity;

/**
 * @Author solin
 * @Date 2021/8/24 22:20
 * @content
 */
public interface AccountService {
    int save(AccountEntity entity);
    int delById(int id);
    void transaction(String sendName,String receiverName,double money);
    AccountEntity selectById(int id);
}
