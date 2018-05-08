package com.wisely.ch7_2.web;

import com.wisely.ch7_2.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * <内容说明>
 *
 * @author jiang.zhenxiong
 * created on 2018/5/8 11:24
 */
@Controller
public class IndexController {

    @RequestMapping("")
    public String index(Model model) {
        Person single = new Person("single", 1);

        List<Person> people = new ArrayList<>();
        people.add(new Person("xx", 11));
        people.add(new Person("yy", 22));
        people.add(new Person("zz", 33));

        model.addAttribute("singlePerson", single);
        model.addAttribute("people", people);
        return "index";
    }
}
