package com.acghome.service.mq;

import com.acghome.controller.FileController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.acghome.conf.RabbitConfig.PRODUCT_INFO_1;

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


    private final static Logger logger = LoggerFactory.getLogger(Producer.class);




    //产品和sku信息变更时发送该消息
    public void productChangeSend(String redis_key,String product_id) {


        HashMap<String, String> data = new HashMap<>();
        data.put("redis_key", redis_key);
        data.put("product_id", product_id);

        String msg = null;
        try {
            msg = objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        logger.info("send msg redis_key: " + msg);


        // 第一个参数为定义的队列名称
        this.rabbitTemplate.convertAndSend(PRODUCT_INFO_1, msg);
    }
}