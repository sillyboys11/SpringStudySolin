package org.example.service.impl;

import org.example.dao.AccountDao;
import org.example.service.AccountService;
import org.example.utils.BeanFactoryUtil;

/**
 * @Author solin
 * @Date 2021/8/14 10:30
 * @content
 */
public class AccountServiceImpl implements AccountService {
    AccountDao accountDao= BeanFactoryUtil.getInstanceBean(AccountDao.class);
    @Override
    public int transaction(String sendUID, String receiverUID, double money) {
        //增加
        accountDao.increase(receiverUID,money);
        //减少
        accountDao.reduce(sendUID,money);
        return 0;
    }
}
