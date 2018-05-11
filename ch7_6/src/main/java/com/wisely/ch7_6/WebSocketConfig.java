package com.wisely.ch7_6;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * <内容说明>
 *
 * @author jiang.zhenxiong
 * created on 2018/5/11 10:16
 */
@Configuration
/*
* 通过@EnableWebSocketMessageBroker注解开启使用STOMP协议来传输基于代理（message broker）的消息。
* 这时控制器支持使用@MessageMapping，就像使用@RequestMapping一样。
* */
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //配置消息代理（Message Broker）
        registry.enableSimpleBroker("/topic");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //注册STOMP协议的节点（endpoint），并映射的指定的URL，指定使用SockJS协议。
        registry.addEndpoint("/endpointWisely").withSockJS();
    }
}
