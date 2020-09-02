package com.tcaini.cardio.elasticsearch.entity;

import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Document(indexName = "cardio", shards = 3, replicas = 3)
public class Employee {

    @Id
    @Field(type = FieldType.Long)
    private Long id;

    @Field(type = FieldType.Integer)
    private Integer age;

    @Field(type = FieldType.Date, format = DateFormat.basic_date)
    private Date birthDt;

    @Field(type = FieldType.Auto)
    private List<String> hobbies;

    @Field(type = FieldType.Text)
    private String description;
}
