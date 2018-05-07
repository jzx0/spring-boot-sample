package com.wisely.spring_boot_starter_hello;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <内容说明>
 *
 * @author jiang.zhenxiong
 * created on 2018/5/7 15:09
 */
@ConfigurationProperties(prefix = "hello")
public class HelloServiceProperties {

    private static final String MSG = "world";

    private String msg = MSG;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
