package com.tcaini.cardio.mongodb.repository;

import com.tcaini.cardio.mongodb.model.Flow;

import java.util.List;
import java.util.Set;

public interface FlowRepository {

    boolean insertFlow(Flow flow);

    List<Flow> findFlows();
}
