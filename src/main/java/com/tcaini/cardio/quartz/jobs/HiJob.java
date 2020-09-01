package com.tcaini.cardio.quartz.jobs;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class HiJob extends QuartzJobBean {

    public HiJob() {
        super();
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("jobExecutionContext.getFireTime="+jobExecutionContext.getFireTime());
    }
}
