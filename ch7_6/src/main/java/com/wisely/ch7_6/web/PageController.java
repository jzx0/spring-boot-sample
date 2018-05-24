package com.wisely.ch7_6.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;


/**
 * <内容说明>
 *
 * @author jiang.zhenxiong
 * created on 2018/5/24 14:29
 */
@Controller
public class PageController {

    @GetMapping("/chat")
    public String chat(@AuthenticationPrincipal Principal Principal, Model model) {
        model.addAttribute("user", Principal);
        return "chat";
    }
}
