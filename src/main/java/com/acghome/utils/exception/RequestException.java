package com.acghome.utils.exception;

/**
 * @author tmh
 * @version 1.0.0
 * @ClassName RequestException.java
 * @Description TODO
 * @createTime 2019年09月12日 15:20:00
 */
public class RequestException extends RuntimeException {

    private String code;
    private String msg;
    private Boolean success=Boolean.FALSE;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }


    public RequestException() {

        this.code = "500";
        this.msg = "参数异常";

    }

    public RequestException(String msg) {

        this.code = "500";
        this.msg = msg;

    }

    public RequestException(String code, String msg) {
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
