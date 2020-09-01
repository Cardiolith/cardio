package com.tcaini.cardio.kafka.handler;

import com.tcaini.cardio.kafka.constants.KafkaConsts;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageHandler {

    @KafkaListener(topics = KafkaConsts.TOPIC_TEST, groupId = "test", containerFactory = "ackContainerFactory")
    public void handleMessage(ConsumerRecord record, Acknowledgment acknowledgment){
        try {
            String message=(String)record.value();
            log.info("收到消息={}", message);
        }catch (Exception e){
            log.error(e.getMessage(), e);
        }finally {
            acknowledgment.acknowledge();
        }
    }
}
