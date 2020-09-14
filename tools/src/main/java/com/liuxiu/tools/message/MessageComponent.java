package com.liuxiu.tools.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageComponent implements InitializingBean {


    /**
     * 直接注入该事件发布器
     */
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void sendMessage() {
        log.info(this.getClass().getName()+" send message");
        //创建事件对象
        MessageEvent messageEvent = new MessageEvent(new Integer(666));
        applicationEventPublisher.publishEvent(messageEvent);
    }

    /**
     * 实现InitializingBean的方法，在bean初始化后调用事件发布方法
     */
    @Override
    public void afterPropertiesSet() {
        sendMessage();
    }
}