package com.acghome.utils;

import org.apache.shiro.crypto.hash.SimpleHash;

//加密工具
public class MD5Utils {

	public static final String KEY="acg"; //加盐
	public static final int NUMBER = 2; //加密次数
	public static String encrypt(String source){
		String encryption="md5";
		SimpleHash hash = new SimpleHash(encryption, source, KEY, NUMBER);
		return hash.toString();
	}
}
