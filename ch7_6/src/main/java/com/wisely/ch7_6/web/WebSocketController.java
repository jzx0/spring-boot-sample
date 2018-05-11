package com.wisely.ch7_6.web;

import com.wisely.ch7_6.domain.WiselyRequest;
import com.wisely.ch7_6.domain.WiselyResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * <内容说明>
 *
 * @author jiang.zhenxiong
 * created on 2018/5/11 10:40
 */
@Controller
public class WebSocketController {

    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public WiselyResponse say(WiselyRequest request) throws InterruptedException {
        Thread.sleep(3000);
        return new WiselyResponse("Welcome," + request.getName() + "!");
    }
}
