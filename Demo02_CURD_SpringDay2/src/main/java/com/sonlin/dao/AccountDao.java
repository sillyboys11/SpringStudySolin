package com.sonlin.dao;

import com.sonlin.domain.Account;

/**
 * @Author solin
 * @Date 2021/8/18 12:43
 * @content
 */
public interface AccountDao {
    Integer save(Account account);

    Account findById(int id);
}
