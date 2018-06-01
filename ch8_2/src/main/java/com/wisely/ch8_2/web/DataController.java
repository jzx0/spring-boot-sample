package com.wisely.ch8_2.web;

import com.wisely.ch8_2.dao.PersonRepository;
import com.wisely.ch8_2.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <内容说明>
 *
 * @author jiang.zhenxiong
 * created on 2018/6/1 16:06
 */
@RestController
public class DataController {

    // Spring Data JPA已自动注册bean，所以可自动注入
    @Autowired
    PersonRepository personRepository;

    /**
     * 保存
     * save支持批量保存：<S extends T>  Iterable <S> save( Iterable<S> entities);
     *
     * 删除：
     * 支持使用id删除对象、批量删除以及删除全部：
     * void delete(ID id);
     * void delete(T entity);
     * void delete( Iterable<? extends T> entities);
     * void deleteAll();
     *
     */
    @RequestMapping("/save")
    public Person save(String name, String address, Integer age) {
        Person p = personRepository.save(
                new Person(null, name, age, address)
        );
        return p;
    }

    @RequestMapping("/findByAddress")
    public List<Person> findByAddress(String address) {
        List<Person> people = personRepository.findByAddress(address);
        return people;
    }

    @RequestMapping("/findByNameAndAddress")
    public Person findByNameAndAddress(String name, String address) {
        Person p = personRepository.findByNameAndAddress(name, address);
        return p;
    }

    @RequestMapping("/withNameAndAddressQuery")
    public Person withNameAndAddressQuery(String name, String address) {
        Person p = personRepository.withNameAndAddressQuery(name, address);
        return p;
    }

    @RequestMapping("/withNameAndAddressNamedQuery")
    public List<Person> withNameAndAddressNamedQuery(String name, String address) {
        List<Person> people = personRepository.withNameAndAddressNamedQuery(name, address);
        return people;
    }

    /**
     * 按照年龄从小到大排序
     * @return
     */
    @RequestMapping("/sort")
    public List<Person> sort() {
        List<Person> people = personRepository.findAll(new Sort(Sort.Direction.ASC, "age"));
        return people;
    }

    /**
     * 分页
     * @return
     */
    @RequestMapping("/page")
    public Page<Person> page(Integer page, Integer size) {
        Page<Person> personPage = personRepository.findAll(PageRequest.of(page, size));
        return personPage;
    }
}
