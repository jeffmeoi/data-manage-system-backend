package com.jeff.datamanagesystem.dto;

public class ErrorCode {
    private Integer code;
    private String msg;
    private Object data;

    public final static ErrorCode FAILED = new ErrorCode(10000,"失败",null);
    public final static ErrorCode NO_ACCESS = new ErrorCode(10001,"无访问权限",null);
    public final static ErrorCode TARGET_IS_EXISTED = new ErrorCode(10002,"已存在",null);
    public final static ErrorCode PARAM_FORMAT_IS_INVALID = new ErrorCode(10003,"参数格式不合法",null);
    public final static ErrorCode LOGIN_FAILED = new ErrorCode(10004,"登录失败",null);
    public final static ErrorCode SQL_INTEGRITY_CCONSTRAINT_VIOLATION_EXCEPTION = new ErrorCode(10005,"违反唯一约束条件",null);


    public ErrorCode() {
    }

    public ErrorCode(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ErrorCode{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public static ErrorCode success(Object data){
        return new ErrorCode(200, "ok", data);
    }

    public static ErrorCode success(){
        return success(null);
    }

}
