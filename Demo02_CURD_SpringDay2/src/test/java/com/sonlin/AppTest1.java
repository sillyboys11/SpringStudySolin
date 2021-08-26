package com.sonlin;

import com.sonlin.domain.Account;
import com.sonlin.service.AccountService;
import com.sonlin.service.impl.AccountServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

/**
 * Unit test for simple App.
 */
public class AppTest1 {

    private AccountService accountService;

    @Before
    public void init(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        accountService= (AccountService) context.getBean(AccountServiceImpl.class);
    }
    @Test
    public void testSave() {
        Account account=new Account();
        account.setMoney(1000);
        account.setName("小白");
        accountService.save(account);
    }

    @Test
    public void testFindById(){
        Account account = accountService.findById(1);
        System.out.println(account.getName()+"--"+account.getMoney());
    }
}
