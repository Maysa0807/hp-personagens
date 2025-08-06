package com.example.hp.producers;

import com.example.hp.dto.EmailRecordDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {
    final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;


    public void publishMessageEmail(EmailRecordDto emailRecordDto) {
        rabbitTemplate.convertAndSend("", routingKey, emailRecordDto);
    }
}