package com.bicycle.config;

public class Result<T> {
    public static final int CODE_OK = 200;
    public static final int CODE_ERR_BUSINESS = 500;
    public static final int CODE_ERR_SYS = 530;
    public static final int CODE_ERR_UNLOGINED = 520;
 
    public static <T>Result<T> ok(){
        return new Result(true,CODE_OK,null,null);
    }
    public static <T>Result<T> ok(String message){
        return new Result(true,CODE_OK,message,null);
    }
    public static <T>Result<T> ok(T data){
        return new Result(true,CODE_OK,null,data);
    }
    public static <T>Result<T> ok(String message,T data){
        return new Result(true,CODE_OK,message,data);
    }
 
    public static <T>Result<T> err(int errCode ,String message){
        return new Result(false,errCode,message,null);
    }
    public static <T>Result<T> err(int errCode ,String message,T data){
        return new Result(false,errCode,message,data);
    }
 
    private boolean success;//是否成功
    private int code;//200 成功 500 业务失败，530 系统错误，520 未登录
    private String message;//概要信息
    private T data;
 
    public Result(boolean success, int code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }
 
    public boolean isSuccess() {
        return success;
    }
 
    public int getCode() {
        return code;
    }
 
    public String getMessage() {
        return message;
    }
 
    public T getData() {
        return data;
    }
}