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

@Controller
@RequestMapping("/product")
public class ProductController extends BaseContorller {
	//商品页
	@RequestMapping("/add_product")
	public String goProductPage(Model model) {
		model.addAttribute("user",UserContext.getUser());
		return "system/add_product";
	}


}
