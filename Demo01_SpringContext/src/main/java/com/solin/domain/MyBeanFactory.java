package com.solin.domain;

/**
 * @Author solin
 * @Date 2021/8/17 12:21
 * @content
 */
public class MyBeanFactory {
    public static MyBean getMyBean(){
        System.out.println("--------getMyBean-----");
        MyBean myBean = new MyBean();
        /*
         *
         * 业务代码
         *
         * */
        return myBean;
    }
}
