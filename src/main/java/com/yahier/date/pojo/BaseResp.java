package com.yahier.date.pojo;

public class BaseResp {
    private int code = 200;
    private String msg = "操作成功";

    public BaseResp() {

    }

    public BaseResp(String msg) {

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
