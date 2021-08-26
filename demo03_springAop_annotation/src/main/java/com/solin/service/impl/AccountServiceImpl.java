package com.solin.service.impl;

import com.solin.dao.AccountDao;
import com.solin.domain.AccountEntity;
import com.solin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author solin
 * @Date 2021/8/24 22:21
 * @content
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public int save(AccountEntity entity) {
        return accountDao.save(entity);
    }


    @Override
    public int delById(int id) {
        return accountDao.delById(id);
    }

    @Override
    public void transaction(String sendName, String receiverName, double money) {
        accountDao.update(sendName, 0 - money);
//        int q=10/0;
        accountDao.update(receiverName, 0 + money);
    }

    @Override
    public AccountEntity selectById(int id) {
        return accountDao.selectById(id);
    }
}
