package com.wisely.ch6_5.web;

import com.wisely.spring_boot_starter_hello.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <内容说明>
 *
 * @author jiang.zhenxiong
 * created on 2018/5/7 16:20
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("")
    public String index() {
        return helloService.sayHello();
    }
}
