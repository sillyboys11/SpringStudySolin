package com.solin.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * @Configuration  标名他是一个配置类
 * @Component 将其添加到容器中 value 相当于起一个别名 可以省略
 * @ComponentScan 表示需要扫描报名 ("包名")，多个使用 ({"com.solin.service","com.solin.domain"})
 * @Import 注解用于引入另外的配置文件 多个使用数据{DBConfig.class,DBConfig2.class}
 */
@Configuration
@ComponentScan({"com.solin.service","com.solin.domain"})
@Import(DBConfig.class)
public class MyConfig {
}
