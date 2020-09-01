package com.tcaini.cardio.rabbitmq.handler;

import cn.hutool.json.JSONUtil;
import com.rabbitmq.client.Channel;
import com.tcaini.cardio.rabbitmq.constants.RabbitConsts;
import com.tcaini.cardio.rabbitmq.message.MessageStruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@RabbitListener(queues = RabbitConsts.DIRECT_MODE_QUEUE_ONE)
@Component
public class DirectQueueOneHandler {

    @RabbitHandler
    public void directHandlerManualAck(MessageStruct messageStruct, Message message, Channel channel){
        final long deliveryTag=message.getMessageProperties().getDeliveryTag();
        try {
            log.info("队列1, 手动ACK, 接收消息: {}", JSONUtil.toJsonStr(messageStruct));
            // 通知 MQ 消息已被成功消费，可以ACK了
            channel.basicAck(deliveryTag, true);
        }catch (IOException e){
            try{
                // 处理失败，重新压入MQ
                channel.basicRecover();
            }catch (IOException e1){
                e1.printStackTrace();
            }
        }
    }
}
