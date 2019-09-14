package com.acghome.controller;


import com.acghome.entity.db1.User;
import com.acghome.utils.Result;
import com.acghome.utils.UserContext;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/system")
public class LoginController extends BaseContorller {
	//登陆页
	@RequestMapping("/login")
	public String login() {
		return "system/login";
	}

	//登陆校验
	@RequestMapping("/loginRequset")
	@ResponseBody
	public Result login(String username, String password) {
		Result result=new Result();
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
				result.setSuccess(false);
				result.setMessage("用户名不存在");
				return result;
			} catch (IncorrectCredentialsException e) {
				result.setSuccess(false);
				result.setMessage("密码不正确");
				return result;
			}catch (AuthenticationException e) {
				result.setSuccess(true);
				result.setMessage("登陆成功");
				return result;
			}
		}

        return result;
	}

	//主页
	@RequestMapping("/shops_index")
	public String shops_index() {
		return "/system/shops_index";
	}

	//首页
	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("user",UserContext.getUser());
		return "system/index";
	}

}
