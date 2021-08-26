package com.solin.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;


/**
 * @Author solin
 * @Date 2021/8/17 14:02
 * @content
 */
public class MyBeanFactoryBean  implements FactoryBean<MyBean> {

    @Override
    public MyBean getObject() throws Exception {
        MyBean myBean = new MyBean();
        myBean.setAddress("青岛");
        myBean.setAge(19);
        return myBean;
    }

    @Override
    public Class<?> getObjectType() {
        return MyBean.class;
    }
}
