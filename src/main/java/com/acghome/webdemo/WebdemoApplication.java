package com.acghome.webdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;




@MapperScan("com.tmh.mapper")//将项目中对应的mapper类的路径加进来就可以了
@ComponentScan(basePackages = {"com.acghome.controller","com.acghome.service", "com.acghome.utils.aspect","com.acghome.conf"})
@SpringBootApplication
public class WebdemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(WebdemoApplication.class, args);
    }

}
