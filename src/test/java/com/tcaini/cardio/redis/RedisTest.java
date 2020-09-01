package com.tcaini.cardio.redis;

import com.tcaini.cardio.CardioApplicationTests;
import com.tcaini.cardio.redis.entity.User;
import com.tcaini.cardio.redis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

@Slf4j
public class RedisTest extends CardioApplicationTests {

    @Autowired
    public RedisTemplate redisTemplate;

    @Autowired
    public UserService userService;

    @Test
    public void testRedisTemplate(){
        log.info("redis connection instanceof {}", redisTemplate.getConnectionFactory().getClass());

        String key="cardio:user:1";
        redisTemplate.opsForValue().set(key, new User(1L, "user1"));
        User user=(User)redisTemplate.opsForValue().get(key);
        log.info("user={}", user);
    }

    @Test
    public void testRedisCache(){
        User user1=userService.get(1L);
        log.debug("【user1】={}", user1);

        User user2=userService.get(1L);
        log.debug("【user2】={}", user2);

        userService.delete(1L);
    }
}
