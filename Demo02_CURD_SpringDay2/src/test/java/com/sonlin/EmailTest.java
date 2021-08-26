package com.sonlin;

import com.sonlin.utils.EmailUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author solin
 * @Date 2021/8/19 13:53
 * @content
 */

public class EmailTest {
    private EmailUtils utils;

    @Before
    public void init(){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
        utils = (EmailUtils) context.getBean(EmailUtils.class);

    }
    @Test
    public void test(){
        utils.sendEmail();
    }
}
