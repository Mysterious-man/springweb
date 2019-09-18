package com.acghome.utils;

import java.util.HashMap;
import java.util.Map;

public class ResultGenerator {


    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    /**
     * 响应码枚举，参考HTTP状态码的语义
     */
    private static final int SUCCESS_CODE=200; //成功
    private static final int FAIL_CODE=400;  //失败
    private static final int UNAUTHORIZED=401;  //未认证（签名错误）
    private static final int NOT_FOUND=404;  //接口不存在
    private static final int INTERNAL_SERVER_ERROR=500; //服务器内部错误


    public static Result genSuccessResult() {

        String data="";

        return genSuccessResult(data);

    }

    public static Result genSuccessResult(Object data) {

        Result result=new Result();

        result.setCode(SUCCESS_CODE);
        result.setMessage(DEFAULT_SUCCESS_MESSAGE);
        result.setSuccess(Boolean.TRUE);

        result.setData(data);

        return result;

    }

    public static Result genFailResult(String message) {

        String data="";

        return genFailResult(message,data);
    }

    public static Result genFailResult(String message,Object data) {

        return  genFailResult(message,data,FAIL_CODE);
    }


    public static Result genFailResult(String message,Object data,int code) {

        Result result=new Result();

        result.setCode(code);
        result.setMessage(message);
        result.setSuccess(Boolean.FALSE);

        Map<String,Object> error =new HashMap<String, Object>();
        error.put("error",data);

        result.setData(error);

        return result;
    }


}
