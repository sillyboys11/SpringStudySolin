package org.example;

import org.example.service.AccountService;
import org.example.utils.BeanFactoryUtil;
import org.junit.Test;

/**
 * @Author solin
 * @Date 2021/8/14 10:37
 * @content
 */
public class SpringTest {
    private AccountService accountService= BeanFactoryUtil.getInstanceBean(AccountService.class);
    @Test
    public void transaction(){
        accountService.transaction("小明","小红",1000);
    }
}
