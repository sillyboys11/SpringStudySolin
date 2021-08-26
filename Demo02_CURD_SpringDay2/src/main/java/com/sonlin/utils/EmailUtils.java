package com.sonlin.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author solin
 * @Date 2021/8/19 13:50
 * @content
 */
@Component
public class EmailUtils {
    @Value("${email.name}")
    private String username;

    @Value("${email.password}")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void sendEmail(){
        System.out.println(this.username+"---"+this.password);
        System.out.println("发送邮件------");
    }
}
