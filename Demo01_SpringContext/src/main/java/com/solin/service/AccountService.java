package com.solin.service;

/**
 * @Author solin
 * @Date 2021/8/14 10:30
 * @content
 */
public interface AccountService {
    int transaction(String sendUID, String receiverUID, double money);
}
