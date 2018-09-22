package com.streamyear.api.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "streamyear")
public class TestConsumer {

    @RabbitHandler
    public void process(String streamyear){
        System.out.println("接收到的消息内容是: " + streamyear);
    }
}
