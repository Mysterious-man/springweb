package com.acghome.utils.aspect;

import com.acghome.utils.Result;
import com.acghome.utils.ResultGenerator;
import com.acghome.utils.exception.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * controller 增强器
 *
 *
 *
**/

@ControllerAdvice
public class ApiControllerAdvice {

    private final static Logger logger = LoggerFactory.getLogger(WebLogAspect.class);


    /**
     * 处理接口前端数据验证异常
     * @param ex
     * @return
     */

    @ResponseBody
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public Result handleMethodArgumentNotValidException(HttpMessageNotReadableException ex){

        String data=ex.getMessage();

        logger.error("数据参数验证失败 "+data, ex);

        return ResultGenerator.genFailResult("数据参数验证失败");
    }


    /**
     * 拦截捕捉自定义异常 ApiException
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = ApiException.class)
    public Result ApiErrorHandler(ApiException ex) {

        logger.error(ex.getMsg(), ex);


        return ResultGenerator.genFailResult(ex.getMsg(),"",ex.getCode());
    }


    /**
     * 全局异常捕捉处理,处理所有不可知的异常
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result errorHandler(Exception ex) {

        logger.error(ex.getMessage(), ex);

        return  ResultGenerator.genFailResult(ex.getMessage());
    }




}
