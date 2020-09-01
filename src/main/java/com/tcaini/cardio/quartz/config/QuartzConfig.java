package com.tcaini.cardio.quartz.config;

import com.tcaini.cardio.quartz.jobs.HiJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail hiJobDetail(){
        JobDetail jobDetail=JobBuilder.newJob(HiJob.class)
                .withIdentity("hiJobDetail", "jobDetail1")
                .usingJobData("startDateTime", new Date().toString())
                .storeDurably()
                .build();
        return jobDetail;
    }

    @Bean
    public Trigger hiTrigger1(){
        Trigger trigger = TriggerBuilder.newTrigger()
                .forJob(hiJobDetail())
                .withIdentity("hiTrigger", "hiTrigger1")
                .usingJobData("startDateTime", new Date().toString())
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ? 2020"))
                .build();
        return trigger;
    }
}
