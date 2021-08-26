package com.solin.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author solin
 * @Date 2021/8/23 23:38
 * @content 动态代理织入事务管理
 */
@Component
public class TransActionProxyFactory {
    @Autowired
    private TransactionManager manager;

    public Object proxyTransaction(final Object o) {
        /**
         * 参数 类加载器，接口
         */
        Object proxyInstance = Proxy.newProxyInstance(TransActionProxyFactory.class.getClassLoader(),
                o.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //被增加的对象的所有逻辑
                        //补充tcf
                        try {
                            manager.startTransaction();
                            Object result = method.invoke(o, args);
                            manager.commitTransaction();
                            return result;
                        } catch (Exception e) {
                            manager.rollBackTransaction();
                            throw new RuntimeException(e);
                        } finally {
                            manager.closeTransaction();
                        }
                    }
                });
        return proxyInstance;
    }
}
