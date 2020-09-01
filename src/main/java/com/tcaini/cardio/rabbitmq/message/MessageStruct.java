package com.tcaini.cardio.rabbitmq.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageStruct implements Serializable {

    private final static long serialVersionUID=1L;

    private String message;
}
