package com.acghome.utils;

import com.acghome.entity.db1.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;


/**
 * 封装一个工具类
 * 向session中存储当前用户对象
 * 获取session中存储的当前用户对象
 * @author Administrator
 *
 */
public class UserContext {
	
	public static  final String LOGINUSER="user_in_session";

	public static User getUser(){
		//当前用户  Subject
		Subject currentUser = SecurityUtils.getSubject();
		return (User) currentUser.getSession().getAttribute(LOGINUSER);
	}
	
	public static void setUser(User user){
		//当前用户  Subject
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.getSession().setAttribute(LOGINUSER, user);
	}
	public static String getIp( ){
		//当前用户 的ip地址
		Subject currentUser = SecurityUtils.getSubject();
		String host = currentUser.getSession().getHost();
		return host;
	}
	
}
