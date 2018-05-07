package com.wisely.ch5_2_3.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <内容说明>
 *
 * @author jiang.zhenxiong
 * created on 2018/5/7 9:59
 */
@RestController
public class HelloController {

    @Value("${book.author}")
    private String bookAuthor;
    @Value("${book.name}")
    private String bookName;

    @RequestMapping("")
    public String index() {
        return "Hello, Spring Boot.";
    }

    @RequestMapping(value = "book")
    public String book() {
        return "book name is:" + bookName + " and book author is:" + bookAuthor;
    }
}
