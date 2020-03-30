package com.jg.blog.config;

import com.jg.blog.utils.IdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 用域将一些实体类放入spring 容器
 * com.jg.blog.config
 * 76773:cl
 * 2020/3/17
 * blog
 */
@Configuration
public class BeanConfig {
    @Bean
    public IdWorker idWorker(){
       return new IdWorker();
    }
}
