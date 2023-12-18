package com.gameserver.kafkaconfig;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.config.TopicBuilder;

public class KafkaTopicConfig {

    NewTopic createTopic(String topic) {
        return TopicBuilder.name(topic).build();
    }
}
