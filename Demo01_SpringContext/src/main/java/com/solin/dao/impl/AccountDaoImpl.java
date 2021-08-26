package com.solin.dao.impl;


import com.solin.dao.AccountDao;

/**
 * @Author solin
 * @Date 2021/8/14 10:31
 * @content
 */
public class AccountDaoImpl implements AccountDao {
    @Override
    public void increase(String receiverUID, Double money) {
        System.out.println(receiverUID+"增加了："+money);
    }

    @Override
    public void reduce(String sendUID, Double money) {
        System.out.println(sendUID+"减少了："+money);
    }
}
