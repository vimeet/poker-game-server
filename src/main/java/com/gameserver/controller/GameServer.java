package com.gameserver.controller;

import com.gameserver.response.ApiResponse;
import jakarta.validation.constraints.NotBlank;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameServer {

    private final Logger LOG = LoggerFactory.getLogger(GameServer.class);

    KafkaTemplate<String, String> kafkaTemplate;

    public GameServer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    void sendMessage(String message, String topicName) {
        LOG.info("Sending : {}", message);
        LOG.info("-------------------------------");

        kafkaTemplate.send(topicName, message);
    }

    @GetMapping(value = "/game-server/start/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<String> startGame(@PathVariable @NotBlank String id) {
        NewTopic topic = TopicBuilder.name(id).build();
        sendMessage("ST", id);
        sendMessage("M1", id);
        sendMessage("M2", id);

        return ApiResponse.ok("DONE");
    }

}
