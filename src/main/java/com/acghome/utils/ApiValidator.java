package com.acghome.utils;


import com.acghome.utils.exception.ApiException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class ApiValidator {


    static public void validate_field(BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                throw new ApiException( "请求参数错误对应字段:" + fieldError.getField() + fieldError.getDefaultMessage());
            }
        }
    }
}
