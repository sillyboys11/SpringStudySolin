package com.solin.service.impl;

import com.solin.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * @Author solin
 * @Date 2021/8/24 20:50
 * @content
 */
@Service//放入spring容器内
public class AccountServiceImpl implements AccountService {
    @Override
    public void save() {
//        int i=5/0;
        System.out.println("方法名：save");
    }

    @Override
    public void findById() {

    }

    @Override
    public void delById() {

    }
}
