package com.example.common.model;

/**
 * Created by hechengjin on 17-8-2.
 */
public class Result<T> {
    private Integer code;
    private String result;
    private T data;

    public static final Integer SUCCESS_CODE = 0;
    public static final String SUCCESS_MSG = "SUCCESS";


    public Result() {
    }

    public Result(T data) {
        this(SUCCESS_CODE,SUCCESS_MSG, data);
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.result = msg;
        this.data = data;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
