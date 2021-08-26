package org.example.dao;

/**
 * @Author solin
 * @Date 2021/8/14 10:31
 * @content
 */
public interface AccountDao {
    void increase(String receiverUID, Double money);

    void reduce(String sendUID, Double money);
}
