package com.solin;

import com.solin.domain.AccountEntity;
import com.solin.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class AppTest {
    @Autowired
    private AccountService accountService;

    @Test
    public void test01() {
        AccountEntity accountEntity = accountService.selectById(1);
        System.out.println(accountEntity);
    }

    /**
     * 注意 事务管理 需要保证是一个sqlConnection 操作的
     */
    @Test
    public void transactionTest(){
        accountService.transaction("小明","小黑",100);
    }
}
