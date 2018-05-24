package com.wisely.ch7_6.web;

import com.wisely.ch7_6.domain.ChatRequest;
import com.wisely.ch7_6.domain.WiselyRequest;
import com.wisely.ch7_6.domain.WiselyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * <内容说明>
 *
 * @author jiang.zhenxiong
 * created on 2018/5/11 10:40
 */
@Controller
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public WiselyResponse say(WiselyRequest request) throws InterruptedException {
        Thread.sleep(3000);
        return new WiselyResponse("Welcome," + request.getName() + "!");
    }

    @MessageMapping("/chat")
    public void handleChat(Principal principal, ChatRequest request) {
        String sendTo = request.getSendTo();
        messagingTemplate.convertAndSendToUser(sendTo, "/queue/notifications", principal.getName() + "-send:" + request.getMsg());
    }
}
