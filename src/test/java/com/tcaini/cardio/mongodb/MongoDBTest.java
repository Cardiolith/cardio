package com.tcaini.cardio.mongodb;

import com.tcaini.cardio.CardioApplicationTests;
import com.tcaini.cardio.mongodb.model.Flow;
import com.tcaini.cardio.mongodb.repository.FlowRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Slf4j
public class MongoDBTest extends CardioApplicationTests {

    @Autowired
    private FlowRepository flowRepository;

    @Test
    public void testMongo(){
        flowRepository.insertFlow(Flow.builder().flowName("flow1").startDate(new Date()).maxNum(10).limited(true).build());
        List<Flow> flows=flowRepository.findFlows();
        log.info("size of flowSet={}", flows.size());
    }
}
