package com.sonlin.service;

import com.sonlin.domain.Account;

/**
 * @Author solin
 * @Date 2021/8/18 12:42
 * @content
 */
public interface AccountService {
    Integer save(Account account);

    Account findById(int id);
}
