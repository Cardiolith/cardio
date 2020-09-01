package com.tcaini.cardio.jpa.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Student {
    private Long id;
    private String num;
    private String name;
    private Integer age;
}
