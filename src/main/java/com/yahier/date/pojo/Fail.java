package com.yahier.date.pojo;

public class Fail extends BaseResp{
    private int code = 201;
    private String msg = "操作失败";

    public Fail() {

    }

    public Fail(String msg) {
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
