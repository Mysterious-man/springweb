package com.acghome.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

public  abstract class BaseContorller {
	 public static  final String SUCCESS="success";
	 public static  final String LOGIN="login";
	 public static  final String LOGINUSER="user_in_session";

	 //解决前端传的时间格式，后台报错
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}
