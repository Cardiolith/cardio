package com.tcaini.cardio.properties.property;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource("classpath:cardio.properties")
public class PersonalProperty {
    @Value("${cardio.name}")
    private String name;
    @Value("${cardio.phone}")
    private String phone;
    @Value("${cardio.email}")
    private String email;
}
