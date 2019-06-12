package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @Author: chihaojie
 * @Date: 2019/6/5 21:42
 * @Version 1.0
 * @Note
 */

@EnableWebMvc
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
@MapperScan("com.dao")
@ComponentScan(basePackages = {"com.*"})
public class StartApp {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(StartApp.class, args);
        System.out.println(".................高考志愿系统微服务启动完成...............");

    }


}
