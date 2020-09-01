package com.tcaini.cardio.rabbitmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RabbitListener(queues = "test_queue")
public class DirectConsumer {

    @RabbitHandler
    public void handleMessage(String msg){
        log.info("receive msg={}", msg);
    }
}
