package com.tcaini.cardio.jpa;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSONUtil;
import com.tcaini.cardio.CardioApplicationTests;
import com.tcaini.cardio.jpa.entity.Department;
import com.tcaini.cardio.jpa.entity.User;
import com.tcaini.cardio.jpa.repository.DepartmentDao;
import com.tcaini.cardio.jpa.repository.UserDao;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONArray;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class DepartmentDaoTest extends CardioApplicationTests {

    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private UserDao userDao;

    @Test
    public void testSave(){
        Collection<Department> departmentList=departmentDao.findDepartmentsByLevels(0);

        if(departmentList.size()==0){
            Department testSave1=Department.builder().name("testSave1").orderNo(0).levels(0).superior(null).build();
            Department testSave1_1=Department.builder().name("testSave1_1").orderNo(0).levels(1).superior(testSave1).build();
            Department testSave1_2=Department.builder().name("testSave1_2").orderNo(0).levels(1).superior(testSave1).build();
            Department testSave1_3=Department.builder().name("testSave1_1_1").orderNo(0).levels(2).superior(testSave1_1).build();
            departmentList.add(testSave1);
            departmentList.add(testSave1_1);
            departmentList.add(testSave1_2);
            departmentList.add(testSave1_3);
            departmentDao.saveAll(departmentList);
        }

        String salt= IdUtil.fastSimpleUUID();
        User testSave3=User.builder().name("cardio").password(SecureUtil.md5("123456")+salt).salt(salt).phoneNumber("17810001234").email("cardio@163.com").status(1).lastLoginTime(new DateTime()).build();
        userDao.save(testSave3);

        userDao.findById(1L).ifPresent(user -> {
            user.setName("添加部门");
            Department dept=departmentDao.findById(2L).get();
            user.setDepartmentList(departmentList);
            userDao.save(user);
        });

        departmentDao.findById(2L).ifPresent(dept->{
            Collection<User> userList=dept.getUserList();
        });
    }
}
