package com.sonlin.service.impl;

import com.sonlin.dao.AccountDao;
import com.sonlin.dao.impl.AccountDaoImpl;
import com.sonlin.domain.Account;
import com.sonlin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;



/**
 * @Component 添加到配置项中
 * 相当于配置文件中，书写配置标签
 * @Service 用于服务器层注解，本质上和 Component("accountService")
 *
 * @Service可以不用写别名，会根据类名注入
 */
//@Component("accountService")
//@Service("accountService")
@Service
public class AccountServiceImpl implements AccountService {

    /**
     * 读取配置项中的 id=accountDao
     * @Resource（name="accountDao"） 可以更具name查找,需要与注入配置文件中的名字相同
     * @Resource (type=AccountDaoImpl.class) 可以根据类型进行查找，但是一个工程内只能有一个实现类，不然会报错
     *
     * 使用类型查找的话，可以使用 @AutoWired 替代 @Resource
     */
//    @Resource(type = AccountDaoImpl.class)
    @Autowired
    AccountDao accountDao;
//
//    public void setAccountDao(AccountDao accountDao) {
//        this.accountDao = accountDao;
//    }

    @Override
    public Integer save(Account account) {
        return accountDao.save(account);
    }

    @Override
    public Account findById(int id) {
        return accountDao.findById(id);
    }
}
