package com.solin.service.impl;

import com.solin.dao.AccountDao;
import com.solin.domain.AccountEntity;
import com.solin.service.AccountService;
import com.solin.transaction.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author solin
 * @Date 2021/8/23 22:09
 * @content
 */
@Service("noTcfAccountService")
public class NoTcfAccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Autowired
    private TransactionManager manager;

    @Override
    public int saveAccount(AccountEntity accountEntity) {
        //
        return accountDao.saveAccount(accountEntity);
    }

    @Override
    public AccountEntity findById(int id) {
        return accountDao.findById(id);
    }

    @Override
    public void delById(int id) {
        //补充事务
        accountDao.delById(id);
    }

    @Override
    public void transaction(String sendName, String receiveName, double mondy) {

//            /////业务代码/////////
//            //减少
        accountDao.update(sendName, 0 - mondy);
            int i=10/0;
        //增加
        accountDao.update(receiveName, 0 + mondy);

    }
}
