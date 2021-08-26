package com.solin.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 * @Author solin
 * @Date 2021/8/25 22:20
 * @content
 */
@Configuration
//配置包扫描
@ComponentScan({"com.solin"})
@PropertySource("classpath:dp.properties")
//开启注解扫描
@EnableAspectJAutoProxy
public class Config {
    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.name}")
    private String name;

    @Value("${jdbc.password}")
    private String password;
    @Bean
    public DataSource getDataSource(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(name);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public QueryRunner getQueryRunner(DataSource dataSource){
        return  new QueryRunner(dataSource);
    }
}
