package com.asiainfo.hardreader.Entitys.response;

import java.io.Serializable;

/**
 * @author duanhong
 * @description 响应基类
 * @date 2019/11/23
 */
public class BaseResponse <T> implements Serializable {
    private String resultCode="0000";
    private String message="操作成功";
    private T result;

    public BaseResponse(){

    }

    public BaseResponse(T result) {
        this.result=result;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
