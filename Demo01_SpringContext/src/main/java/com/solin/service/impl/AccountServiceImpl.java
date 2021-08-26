package com.solin.service.impl;


import com.solin.dao.AccountDao;
import com.solin.service.AccountService;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author solin
 * @Date 2021/8/14 10:30
 * @content
 */
public class AccountServiceImpl implements AccountService {
    /**
     * 命名空间注入
     */
    private String p1;
    private String p2;

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }

    /**
     * 构造方法注入
     */
    private String desc;
    private String xx;

    public AccountServiceImpl() {
    }

    public AccountServiceImpl(String desc, String xx) {
        this.desc = desc;
        this.xx = xx;
    }

    /**
     * properties 注入
     */
    private String[] ss;
    private List<String> names;
    private Set<String>  hobby;
    private Map<String,String> book;

    public void setSs(String[] ss) {
        this.ss = ss;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public void setHobby(Set<String> hobby) {
        this.hobby = hobby;
    }

    public void setBook(Map<String, String> book) {
        this.book = book;
    }

    private int id;
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    private AccountDao accountDao;

    //spring 对象注入需要提供set方法
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public int transaction(String sendUID, String receiverUID, double money) {
        //增加
        accountDao.increase(receiverUID, money);
        //减少
        accountDao.reduce(sendUID, money);
        return 0;
    }
}
