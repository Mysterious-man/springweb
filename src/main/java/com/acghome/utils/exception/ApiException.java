package com.acghome.utils.exception;

public class ApiException  extends RuntimeException{


    private String code;
    private String msg;
    private Boolean success=Boolean.FALSE;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }


    public ApiException() {

        this.code = "500";
        this.msg = "接口异常";
    }

    public ApiException(String msg) {

        this.code = "500";
        this.msg = msg;
    }

    public ApiException(String code, String msg) {
        this.code = code;
        this.msg = msg;

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
