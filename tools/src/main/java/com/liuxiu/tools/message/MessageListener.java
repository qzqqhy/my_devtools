package com.liuxiu.tools.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageListener implements ApplicationListener<MessageEvent> {


    @Override
    public void onApplicationEvent(MessageEvent event) {
        log.info(this.getClass().getName() + " receive message!!! source = " + event.getSource());
    }
}