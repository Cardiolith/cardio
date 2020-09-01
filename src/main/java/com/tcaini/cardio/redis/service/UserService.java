package com.tcaini.cardio.redis.service;

import com.tcaini.cardio.redis.entity.User;

public interface UserService {
    User saveOrUpdate(User user);
    User get(Long id);
    void delete(Long id);
}
