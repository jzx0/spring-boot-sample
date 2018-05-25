package com.wisely.ch7_7.web;

import com.wisely.ch7_7.model.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <内容说明>
 *
 * @author jiang.zhenxiong
 * created on 2018/5/24 16:03
 */
@RestController
public class PersonController {

    @RequestMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person search(String personName) {
        return new Person(personName, 23, "广州");
    }
}
