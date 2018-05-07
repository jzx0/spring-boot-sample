package com.wisely.ch5_2_3.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * <内容说明>
 *
 * @author jiang.zhenxiong
 * created on 2018/5/7 10:52
 */
@Component
@ConfigurationProperties(prefix = "author")
@PropertySource("classpath:config/author.properties")
public class AuthorSettings {

    private String name;
    private Long age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}
