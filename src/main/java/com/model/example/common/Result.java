package com.model.example.common;


import java.util.ArrayList;

public class Result<T> {
    private String status;
    private String message;
    private T data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result() {
    }

    public Result(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Result(T data) {
        this.data = data;
    }

    public static <T> Result success(T data){
        return new Result(Constants.SUCCESS,"成功",data);
    }

    public static Result success(){
        return new Result(Constants.SUCCESS,"成功",new ArrayList());
    }

    public static Result error(String message){
        return new Result(Constants.PROGRAM_ERROR,message,new ArrayList());
    }

    public static Result error(String status,String message){
        return new Result(status,message,new ArrayList());
    }

    public static Result paramIsNull(){
        return new Result(Constants.PROGRAM_ERROR,"参数为空","");
    }

}
