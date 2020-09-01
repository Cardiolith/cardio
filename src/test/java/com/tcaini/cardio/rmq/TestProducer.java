package com.tcaini.cardio.rmq;

import com.tcaini.cardio.CardioApplicationTests;
import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class TestProducer extends CardioApplicationTests {

    @Autowired
    RabbitMessagingTemplate rabbitMessagingTemplate;

    @Test
    public void produce(){
        rabbitMessagingTemplate.convertAndSend("test_queue", "hello RabbitMQ");
    }
}
