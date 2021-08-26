package com.solin;

import com.solin.config.MyConfig;
import com.solin.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ContextConfiguration(classes = MyConfig.class)
 * spring注解工程使用 的配置类
 *
 * RunWith：内置的测试启动类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MyConfig.class)
public class AppTestSpring {
    @Autowired
    private AccountService accountService;
    @Test
    public void test(){
        System.out.println(accountService);
    }
}
