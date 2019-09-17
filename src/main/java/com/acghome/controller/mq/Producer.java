package com.acghome.controller.mq;

import com.acghome.conf.RabbitConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * @author tmh
 * @version 1.0.0
 * @ClassName RabbitProducer.java
 * @Description TODO
 * @createTime 2019年09月16日 18:30:00
 */

@Component
public class Producer {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    

    public void productChangeSend(String redis_key,int product_id) {


        HashMap<String, Object> data = new HashMap<>();
        data.put("redis_key", redis_key);
        data.put("product_id", product_id);

        String msg = null;
        try {
            msg = objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println("[string] send msg redis_key: " + msg);

        // 第一个参数为定义的队列名称
        this.rabbitTemplate.convertAndSend("string", "[string] send msg redis_key: ");
    }
}