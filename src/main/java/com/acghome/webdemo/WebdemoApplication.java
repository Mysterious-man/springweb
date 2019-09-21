package com.acghome.webdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@MapperScan("com.acghome.mapper")//将项目中对应的mapper类的路径加进来就可以了
@ComponentScan(basePackages = {"com.acghome.controller","com.acghome.service", "com.acghome.utils.aspect","com.acghome.conf"})
@SpringBootApplication
@EnableScheduling
public class WebdemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(WebdemoApplication.class, args);
    }


}
