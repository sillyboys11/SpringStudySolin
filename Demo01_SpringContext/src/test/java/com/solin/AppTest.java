package com.solin;

import com.solin.domain.MyBean;
import com.solin.service.AccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * spring 自带bean工程，单例
     */
    @Test
    public void test01() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        AccountService accountService = (AccountService) context.getBean("accountService");
        System.out.println(accountService);
        AccountService accountService1 = (AccountService) context.getBean("accountService");
        System.out.println(accountService1);
    }

    /**
     * 对象注入
     */
    @Test
    public void test2() {
        //注入对象  主要看AccountService 中的方法，AccountService 引用了AccountDao
        //在Spring 配置文件中beans.xml 添加属性properties
        //在AccountServiceImpl 中添加引用对象的set方法
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        AccountService accountService = (AccountService) context.getBean("accountService");
        accountService.transaction("小明", "小红", 1000);
    }

    /**
     * 属性注入 类型
     * 构造函数注入
     *
     * 基本类型注入
     * int 类型
     * String 类型
     * 数组类型
     * list
     * set
     * map
     */
    @Test
    public void test3(){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
        AccountService accountService = (AccountService) context.getBean("accountService");
        System.out.println("1111");
    }

    /**
     * 命名空间 p注入
     * xmlns:p="http://www.springframework.org/schema/p"
     */
    @Test
    public void test4(){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
        AccountService accountService = (AccountService) context.getBean("accountService");
        System.out.println("1111");
    }

    /**
     * 静态工厂创建 创建对象
     */
    @Test
    public void test5(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        MyBean myBean = (MyBean) context.getBean("myBean");
        System.out.println(myBean);
        System.out.println("11111");
    }

    /**
     * 示例工厂模式，先创建工厂实例，调用方法创建对象
     */
    @Test
    public void test6(){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
        MyBean myBean2 = (MyBean) context.getBean("myBean2");
        System.out.println("实例工厂模式："+myBean2);
    }

    /**
     * spring 标准工厂实例模式，implements factoryBean
     */
    @Test
    public void test7(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        MyBean myBean3 = (MyBean) context.getBean("myBean3");
        System.out.println("标准化："+myBean3);
    }
}
