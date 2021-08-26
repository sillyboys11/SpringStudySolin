package com.sonlin.dao.impl;

import com.sonlin.dao.AccountDao;
import com.sonlin.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;


/**
 * @Component 相当于将类添加到配置文件中 等同于配置项
 * <bean id="accountDao" class="com.sonlin.dao.impl.AccountDaoImpl">
 * <property name="queryRunner" ref="queryRunner"/>
 * </bean>
 * repository 持久化的意思
 * repository 相遇component的别名，只是使用者进行区分！本质上没有啥区别
 * @Repository 可以不起别名
 */
//@Component("accountDao")
//@Repository("accountDao")
@Repository
public class AccountDaoImpl implements AccountDao {
    /**
     * 从配置项中读取 id 为queryRunner bean
     * <p>
     * 配置文件注入需要 set方法注入
     * <p>
     * 注解是通过反射暴力注入
     */
    @Resource(name = "queryRunner")
    QueryRunner queryRunner;

//    public void setQueryRunner(QueryRunner queryRunner) {
//        this.queryRunner = queryRunner;
//    }

    @Override
    public Integer save(Account account) {
        String sql = "insert into tr_account values(null,?,?)";
        try {
            return queryRunner.update(sql, account.getName(), account.getMoney());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findById(int id) {
        String sql = "select * from tr_account where id=?";
        try {
            return queryRunner.query(sql, new BeanHandler<>(Account.class), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
