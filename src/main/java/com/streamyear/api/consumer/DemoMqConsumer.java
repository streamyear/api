package com.streamyear.api.consumer;

import io.github.rhwayfun.springboot.rocketmq.starter.common.AbstractRocketMqConsumer;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DemoMqConsumer extends AbstractRocketMqConsumer<DemoMqTopic, DemoMqContent> {

    @Override
    public Map<String, Set<String>> subscribeTopicTags() {
        Map<String, Set<String>> map = new HashMap<>();
        Set<String> tags = new HashSet<>();
        tags.add("test-tag");
        map.put("test-topic", tags);
        return map;
    }

    @Override
    public String getConsumerGroup() {
        return "test-consumer-group";
    }

    @Override
    public boolean consumeMsg(DemoMqContent content, MessageExt messageExt) {
        System.out.println(new Date() + ", " + content);
        return true;
    }
}

