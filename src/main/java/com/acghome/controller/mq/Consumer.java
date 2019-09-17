package com.acghome.controller.mq;

import com.acghome.conf.RabbitConfig;
import com.acghome.controller.PictureController;
import com.acghome.pojo.dto.GetProductEditDTO;
import com.acghome.service.IProductService;
import com.acghome.utils.ResultGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author tmh
 * @version 1.0.0
 * @ClassName StringConsumer.java
 * @Description TODO
 * @createTime 2019年09月16日 18:32:00
 */


@Component
public class Consumer {

    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private IProductService productService;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;


    private final static Logger logger = LoggerFactory.getLogger(PictureController.class);


    /**
     * 消息消费
     * @RabbitHandler 代表此方法为接受到消息后的处理方法
     */

    @RabbitListener(queues = "string")
    @RabbitHandler
    public void recieved(String msg) {

        try {
            logger.info("recieved sucesss");

//            HashMap data = null;
//            try {
//                data=objectMapper.readValue(msg, HashMap.class);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            GetProductEditDTO result_data = productService.getProductAndSku((Integer) data.get("product_id"));
//
//            if (result_data.getProduct() == null) {
//
//                logger.info("？？？？？");
//            }
//            else {
//                redisTemplate.opsForValue().set(data.get("redis_key"),result_data);
//            }
//
//            logger.info("[string] recieved message:" + result_data.toString());
        } catch (Exception e) {
            logger.info("#####");
        }
    }

}
