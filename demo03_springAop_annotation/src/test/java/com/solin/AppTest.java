package com.solin;

import com.solin.config.Config;
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
@ContextConfiguration(classes = Config.class)
public class AppTest {

    @Autowired
    private AccountService accountService;
    @Test
    public void test01() {
        accountService.transaction("小明","小黑",100);
    }
}
