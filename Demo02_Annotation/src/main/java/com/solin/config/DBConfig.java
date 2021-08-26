package com.solin.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @Configuration 表明是配置项
 * @Component 添加到spring容器中
 * @ComponentScan("com.solin.dao") 需要扫描的包名
 * 相当于：<context:component-scan base-package="com.sonlin.dao,
 * com.sonlin.service,
 * com.sonlin.utils"/>
 *
 * @PropertySource("classpath:db.properties")    相当于引入外部配置文件
 * 等同于
 *     <context:property-placeholder location="classpath:db.properties,classpath:email.properties"/>
 */
@Configuration
@ComponentScan("com.solin.dao")
@PropertySource("classpath:db.properties")
public class DBConfig {
    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.name}")
    private String name;

    @Value("${jdbc.password}")
    private String password;
    /**
     * 含义：当spring框架已注解方式启动 扫描配置类 方法
     *      如果方法有@Bean注解 将该方法的返回值 放到spring容器中
     *      作用等同于：注解相当于在配置文件中<bean id=”“></bean> 标签
     *      <bean id="queryRunner" class="org.apache.commons.dbutils.QueryRunner">
     *      <constructor-arg name="ds" ref="dataSource"/>
     *      </bean>
     */
    @Bean
    public QueryRunner getQueryRunner(DataSource dataSource) {
        QueryRunner queryRunner = new QueryRunner(dataSource);
        return queryRunner;
    }

    @Bean
    public DataSource createDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mysqlstudy?characterEncoding=UTF-8");
//        dataSource.setUsername("root");
//        dataSource.setPassword("123");
        dataSource.setDriverClassName(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(name);
        dataSource.setPassword(password);
        return dataSource;
    }
}
