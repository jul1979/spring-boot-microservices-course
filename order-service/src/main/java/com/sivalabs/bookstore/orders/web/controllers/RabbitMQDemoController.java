package com.sivalabs.bookstore.orders.web.controllers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sivalabs.bookstore.orders.ApplicationProperties;

@RestController
public class RabbitMQDemoController {

    private final RabbitTemplate rabbitTemplate;
    private final ApplicationProperties properties;

    public RabbitMQDemoController(RabbitTemplate rabbitTemplate, ApplicationProperties properties) {
        this.rabbitTemplate = rabbitTemplate;
        this.properties = properties;
    }

    @PostMapping("/send")
    public void sendMessage(@RequestBody MyMessage message) {
        rabbitTemplate.convertAndSend(
                properties.orderEventsExchange(),
                message.routingKey(),
                message.payload());
    }
}

record MyMessage(String routingKey, MyPayload payload) {
}

record MyPayload(String content) {
}
