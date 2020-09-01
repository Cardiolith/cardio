package com.tcaini.cardio.quartz.scheduler;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Slf4j
public class MyScheduler {

    @Scheduled(cron = "0 0/1 * * * ? ")
    public void sendMessage(){
        log.info("current date={}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
