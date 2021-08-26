package com.solin;

import com.solin.domain.AccountEntity;
import com.solin.service.AccountService;
import com.solin.transaction.TransActionProxyFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class AppTest {

    @Autowired
    @Qualifier("tcfAccountService")
    private AccountService accountService;

    @Autowired
    @Qualifier("noTcfAccountService")
    private AccountService noTcfAccountService;

    @Autowired
    private TransActionProxyFactory proxyFactory;
    @Test
    public void testSave() {
        System.out.println(accountService);
    }

    @Test
    public void testFindById(){
        AccountEntity entity = accountService.findById(1);
        System.out.println(entity);
    }
    @Test
    public void transactionTest(){
        accountService.transaction("小明","小黑",100);
    }

    @Test
    public void noTcfTransactionTest(){
        //增加对象  手动装配--spring自动装配
        AccountService o = (AccountService) proxyFactory.proxyTransaction(noTcfAccountService);
        o.transaction("小明","小黑",100);
    }
}
