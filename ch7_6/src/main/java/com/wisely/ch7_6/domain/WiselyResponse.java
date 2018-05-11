package com.wisely.ch7_6.domain;

/**
 * <内容说明>
 *
 * @author jiang.zhenxiong
 * created on 2018/5/11 10:39
 */
public class WiselyResponse {

    private String responseMessage;

    public WiselyResponse() {
    }

    public WiselyResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
