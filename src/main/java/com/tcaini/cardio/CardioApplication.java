package com.tcaini.cardio;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Slf4j
@EnableScheduling
public class CardioApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CardioApplication.class, args);
        int length=context.getBeanDefinitionNames().length;
        log.trace("Spring Boot初始化了{}个bean", length);
        log.debug("Spring Boot初始化了{}个bean", length);
        log.info("Spring Boot初始化了{}个bean", length);
        log.warn("Spring Boot初始化了{}个bean", length);
        log.error("Spring Boot初始化了{}个bean", length);
    }
}
