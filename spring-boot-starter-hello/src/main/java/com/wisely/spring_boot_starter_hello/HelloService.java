package com.wisely.spring_boot_starter_hello;

/**
 * <内容说明>
 *
 * @author jiang.zhenxiong
 * created on 2018/5/7 15:16
 */
public class HelloService {

    private String msg;

    public String sayHello() {
        return "Hello " + msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
