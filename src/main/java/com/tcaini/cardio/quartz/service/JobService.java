package com.tcaini.cardio.quartz.service;

import com.tcaini.cardio.quartz.entity.JobAndTrigger;

import java.util.List;

public interface JobService {

    List<JobAndTrigger> list();


}
