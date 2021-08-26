package com.solin.domain;

/**
 * @Author solin
 * @Date 2021/8/17 12:37
 * @content 实例对象工厂
 */
public class InstanceBeanFactory {
    public  MyBean getMyBean(){
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
