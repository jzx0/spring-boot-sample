package com.wisely.ch7_6.domain;

/**
 * <内容说明>
 *
 * @author jiang.zhenxiong
 * created on 2018/5/11 14:14
 */
public class ChatRequest {

    private String sendTo;

    private String msg;

    public String getSendTo() {
        return sendTo;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
