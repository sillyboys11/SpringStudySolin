package com.solin.service.impl;

import com.solin.dao.AccountDao;
import com.solin.domain.AccountEntity;
import com.solin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author solin
 * @Date 2021/8/19 22:47
 * @content  @Service==@Component
 */
@Service
public class AccountServiceImpl implements AccountService {
    //获取容器内的对象 根据类型获取
    @Autowired
    private AccountDao accountDao;

    @Override
    public int save(AccountEntity entity) {
        return accountDao.save(entity);
    }

    @Override
    public AccountEntity findById(int id) {
        return accountDao.findById(id);
    }
}
