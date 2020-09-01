package com.tcaini.cardio.mongodb.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;

@Document("flow")
@Data
@Builder
public class Flow implements Serializable {

    private static final long serialVersionUID=1L;

    @Field(name = "flow_name")
    private String flowName;

    @Field(name = "max_num")
    private Integer maxNum;

    @Field(name = "start_date")
    private Date startDate;

    @Field(name = "end_date")
    private Date endDate;

    private Boolean limited;
}
