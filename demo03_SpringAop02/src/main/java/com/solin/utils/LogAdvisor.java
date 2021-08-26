package com.solin.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * @Author solin
 * @Date 2021/8/24 20:53
 * @content
 */
@Component
public class LogAdvisor {
    public void before() {
        System.out.println("在方法执行之前执行加强逻辑");
    }

    public void after() {
        System.out.println("在方法执行之后执行加强逻辑");
    }

    public void throwing() {
        System.out.println("在方法报错时执行加强逻辑");
    }

    public void finallyX() {
        System.out.println("在方法结束时执行加强逻辑");
    }

    /**
     * 环绕通知
     */
    public Object around(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("方法执行之前。。。");
            //方法需要执行的代码  调用原本的方法逻辑
            Object o = joinPoint.proceed();
            System.out.println("方法执行之后。。。");
            return o;
        } catch (Throwable e) {
            System.out.println("报错。。。");
            throw new RuntimeException(e);
        } finally {
            System.out.println("最终。。。");
        }
    }
}
