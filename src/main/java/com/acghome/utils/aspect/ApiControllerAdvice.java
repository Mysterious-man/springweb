package com.acghome.utils.aspect;

import com.acghome.utils.exception.ApiException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * controller 增强器
 *
 *
 *
**/

@ControllerAdvice
public class ApiControllerAdvice {

//    /**
//     * 全局异常捕捉处理
//     * @param ex
//     * @return
//     */
//    @ResponseBody
//    @ExceptionHandler(value = Exception.class)
//    public Map errorHandler(Exception ex) {
//        Map map = new HashMap();
//        map.put("code", 100);
//        map.put("msg", ex.getMessage());
//        return map;
//    }

    /**
     * 拦截捕捉自定义异常 MyException.class
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = ApiException.class)
    public Map ApiErrorHandler(ApiException ex) {
        Map<String,Object> map = new HashMap<>();
        map.put("code", ex.getCode());
        map.put("msg", ex.getMsg());
        map.put("success",ex.getSuccess());
        return map;
    }






}
