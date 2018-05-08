package com.wisely.ch7_2.model;

/**
 * <内容说明>
 *
 * @author jiang.zhenxiong
 * created on 2018/5/8 11:03
 */
public class Person {

    private String name;
    private Integer age;

    public Person() {

    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
