package com.tcaini.cardio.jpa;

import cn.hutool.core.lang.Console;
import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;
import com.tcaini.cardio.CardioApplicationTests;
import com.tcaini.cardio.jpa.entity.Student;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@Slf4j
public class JdbcDateSourceTest extends CardioApplicationTests {

    @Autowired
    private DataSource dataSource;

    @Test
    public void conn(){
        log.info("dateSource instanceof {}", dataSource.getClass());
        try {
            Connection connection=dataSource.getConnection();
            Statement statement=connection.createStatement();
            String sql="select * from student";
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                Student student=new Student();
                student.setId(resultSet.getLong("id"));
                student.setName(resultSet.getString("name"));
                student.setNum(resultSet.getString("num"));
                student.setAge(resultSet.getInt("age"));
                log.info("【student】={}", student);
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testDruid(){
        DruidDataSource druidDataSource=(DruidDataSource)dataSource;
        log.info("druid.initialSize={}\ndruid.maxActive={}",druidDataSource.getInitialSize(),druidDataSource.getMaxActive());
    }
}
