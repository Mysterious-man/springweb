package com.acghome.controller;


import com.acghome.entity.db1.User;
import com.acghome.utils.UserContext;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/system")
public class LoginController extends BaseContorller {

	@RequestMapping("/login")
	public String index() {
		return "system/login";
	}
	
	@RequestMapping("/loginRequset")
	public String login(String username, String password) {
		// 获取到当前登录的用户 shiro的Subject
		Map<String ,Object> map=new HashMap<>();
		Subject currentUser = SecurityUtils.getSubject();
		// 判断用户是否以认证
		if (!currentUser.isAuthenticated()) {
			// 身份认证
			// 封装token
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			// 调用Subject的login方法进行登录
			try {
				currentUser.login(token);
				// 将用户信息放到session中
				// user对象
				User user = (User) currentUser.getPrincipal();
				
				// 存入到session中 我们使用的是shiro的session
				UserContext.setUser(user);
			} catch (UnknownAccountException e) {
				e.printStackTrace();
				// 用户名不存在
				map.put(SUCCESS,false);
				return "login/index";
			} catch (IncorrectCredentialsException e) {
				e.printStackTrace();
				// 密码不正确
				map.put(SUCCESS,false);
				return "login/index";
			}catch (AuthenticationException e) {
				e.printStackTrace();
				map.put(SUCCESS,false);
				return "login/index";
			}
		}
		map.put(SUCCESS,true);

        return "main";
	}

}
