package com.solin.domain;

import java.io.Serializable;

/**
 * @Author solin
 * @Date 2021/8/17 12:18
 * @content
 */
public class MyBean implements Serializable {

    private int age;
    private String name;
    private String address;
    private String phone;

    public MyBean() {
    }

    public MyBean(int age, String name, String address, String phone) {
        this.age = age;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
