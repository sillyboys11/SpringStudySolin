package com.solin;

import com.solin.config.MyConfig;
import com.solin.domain.AccountEntity;
import com.solin.service.AccountService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void test1() {
        //service -->dao-->queryRunner-->datasource
        //创建获取容器的对象 --传递配置类
        /**
         *  AnnotationConfigApplicationContext   是读取注解的实现类
         *  ClassPathXmlApplicationContext       是读取配置文件的实现类
         */
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);
        AccountService accountService = context.getBean(AccountService.class);
        System.out.println(accountService);
        AccountEntity accountEntity = accountService.findById(1);
        System.out.println(accountEntity);
    }
}
