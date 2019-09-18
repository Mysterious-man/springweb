package com.acghome.utils.exception;




public class ApiException  extends RuntimeException{


    private int code;
    private String msg;

    public ApiException() {

        this.code = 405;
        this.msg = "接口异常";
    }

    public ApiException(String msg) {

        this.code = 405;
        this.msg = msg;
    }

    public ApiException(int code, String msg) {
        this.code = code;
        this.msg = msg;

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }




}
