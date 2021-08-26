package com.sonlin;

import com.sonlin.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author solin
 * @Date 2021/8/20 0:44
 * @content
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class AppTestSpring {
    @Autowired
    private AccountService accountService;
    @Test
    public void test(){
        System.out.println(accountService);
    }
}
