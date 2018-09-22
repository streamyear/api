package com.streamyear.api.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "orderQueue")
public class OrderQueue {

    @RabbitHandler
    public void process(String manager){
        System.out.println("orderQueue收到的内容为: " + manager);
    }
}
