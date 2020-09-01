package com.tcaini.cardio.redis.service.impl;

import com.google.common.collect.Maps;
import com.tcaini.cardio.redis.entity.User;
import com.tcaini.cardio.redis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private static final Map<Long, User> DATEBASES=Maps.newConcurrentMap();

    /**
     * 模拟数据库数据
     */
    static {
        DATEBASES.put(1L, new User(1L, "user1"));
        DATEBASES.put(2L, new User(2L, "user2"));
        DATEBASES.put(3L, new User(3L, "user3"));
    }

    /**
     * 保存或修改用户
     * @param user
     * @return
     */
    @Override
    @CachePut(value = "user", key = "#user.id")
    public User saveOrUpdate(User user) {
        DATEBASES.put(user.getId(), user);
        log.info("保存用户user={}", user);
        return user;
    }

    /**
     * 查询用户
     * @param id
     * @return
     */
    @Override
    @Cacheable(value = "user", key = "#id")
    public User get(Long id) {
        log.info("查询用户id={}", id);
        return DATEBASES.get(id);
    }

    /**
     * 删除用户
     * @param id
     */
    @Override
    @CacheEvict(value = "user", key = "#id")
    public void delete(Long id) {
        DATEBASES.remove(id);
        log.info("删除用户id={}", id);
    }
}
