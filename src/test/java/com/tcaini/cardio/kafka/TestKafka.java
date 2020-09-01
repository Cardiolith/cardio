package com.tcaini.cardio.kafka;

import com.tcaini.cardio.CardioApplicationTests;
import com.tcaini.cardio.kafka.constants.KafkaConsts;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

@Slf4j
public class TestKafka extends CardioApplicationTests {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Test
    public void sendMsg(){
        kafkaTemplate.send(KafkaConsts.TOPIC_TEST, "hello kafka");
    }
}
