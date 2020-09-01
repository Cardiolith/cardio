package com.tcaini.cardio.mongodb.repository.impl;

import com.tcaini.cardio.mongodb.model.Flow;
import com.tcaini.cardio.mongodb.repository.FlowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class FlowRepositoryImpl implements FlowRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public boolean insertFlow(Flow flow) {
        mongoTemplate.save(flow);
        return true;
    }

    @Override
    public List<Flow> findFlows() {
        List<Flow> flowList = mongoTemplate.findAll(Flow.class);
        return flowList;
    }
}
