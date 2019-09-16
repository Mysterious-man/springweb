package com.acghome.conf;
import com.acghome.shiro.MyRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 shiroFilter方法：
 这个方法看名字就知道了：shiro的过滤器，可以设置登录页面（setLoginUrl）、权限不足跳转页面（setUnauthorizedUrl）、具体某些页面的权限控制或者身份认证。
 注意：这里是需要设置SecurityManager（setSecurityManager）。
 默认的过滤器还有：anno、authc、authcBasic、logout、noSessionCreation、perms、port、rest、roles、ssl、user过滤器。
 具体的大家可以查看package org.apache.shiro.web.filter.mgt.DefaultFilter。这个类，常用的也就authc、anno。
 securityManager 方法：
 查看源码可以知道 securityManager是一个接口类，我们可以看下它的实现类：
 具体怎么实现的，感兴趣的同学可以看下。由于项目是一个web项目，所以我们使用的是DefaultWebSecurityManager ，然后设置自己的Realm。
 CustomRealm 方法：
 将 customRealm的实例化交给spring去管理，当然这里也可以利用注解的方式去注入。
 */
@Configuration
public class ShiroConfig {

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        shiroFilterFactoryBean.setLoginUrl("/system/login");
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized.jsp");
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/login/loginRequset", "anon");
        filterChainDefinitionMap.put("/hello", "anon");

        //主要这行代码必须放在所有权限设置的最后，不然会导致所有 url 都被拦截 剩余的都需要认证
//        filterChainDefinitionMap.put("/**", "authc");
        filterChainDefinitionMap.put("/**", "anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm());
        return securityManager;
    }

    @Bean
    public MyRealm myRealm() {
        MyRealm myRealm = new MyRealm();
        return myRealm;
    }




}