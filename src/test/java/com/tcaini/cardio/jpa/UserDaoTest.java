package com.tcaini.cardio.jpa;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.google.common.collect.Lists;
import com.tcaini.cardio.CardioApplicationTests;
import com.tcaini.cardio.jpa.entity.User;
import com.tcaini.cardio.jpa.repository.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
public class UserDaoTest extends CardioApplicationTests {

    @Autowired
    private UserDao userDao;

    /**
     * 测试保存
     */
    @Test
    public void testSave(){
        String salt= IdUtil.fastSimpleUUID();
        User testSave3=User.builder().name("cardio").password(SecureUtil.md5("123456")+salt).salt(salt).phoneNumber("17810001234").email("cardio@163.com").status(1).lastLoginTime(new DateTime()).build();
        userDao.save(testSave3);

        Assert.assertNotNull(testSave3.getId());
        Optional<User> byId=userDao.findById(testSave3.getId());
        Assert.assertTrue(byId.isPresent());
        log.debug("【byId】={}", byId.get());
    }

    /**
     * 测试删除
     */
    @Test
    public void testDel(){
        long count=userDao.count();
        userDao.deleteById(1L);

        long left=userDao.count();
        Assert.assertEquals(count-1, left);
    }

    /**
     * 测试修改
     */
    @Test
    public void testUpdate(){
        userDao.findById(1L).ifPresent(user->{
            user.setName("JPA修改");
            userDao.save(user);
        });
        Assert.assertEquals("JPA修改", userDao.findById(1L).get().getName());
    }

    /**
     * 测试分页查询
     */
    @Test
    public void testQueryPage(){
        initData();

        Integer currentPage=0, pageSize=5;
        Sort sort=Sort.by(Sort.Direction.DESC, "id");
        PageRequest pageRequest=PageRequest.of(currentPage, pageSize, sort);
        Page<User> userPage=userDao.findAll(pageRequest);

        Assert.assertEquals(5, userPage.getSize());
        Assert.assertEquals(userDao.count(), userPage.getTotalElements());
        log.info("【id】={}", userPage.getContent().stream().map(User::getId).collect(Collectors.toList()));
    }

    private void initData(){
        List<User> userList= Lists.newArrayList();
        for(int i=0; i<10; i++){
            String salt=IdUtil.fastSimpleUUID();
            int idx=3+i;
            User user=User.builder().name("testSave"+idx).password(SecureUtil.md5("123456")+salt).salt("salt").phoneNumber("17810001234").email("cardio@163.com").status(1).lastLoginTime(new DateTime()).build();
            userList.add(user);
        }
        userDao.saveAll(userList);
    }

}
