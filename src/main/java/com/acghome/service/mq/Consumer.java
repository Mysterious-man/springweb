package com.acghome.service.mq;

import com.acghome.pojo.dto.export.GetProductEditDTO;
import com.acghome.service.IProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

import static com.acghome.conf.RabbitConfig.PRODUCT_INFO_1;

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


    private final static Logger logger = LoggerFactory.getLogger(Consumer.class);


    /**
     * 消费订阅的产品和sku字段的值变更的消息
     * @RabbitHandler 代表此方法为接受到消息后的处理方法
     */
    @RabbitListener(queues = PRODUCT_INFO_1)
    @RabbitHandler
    public void recievedUpdateRedisPid(String msg) {

        logger.info("recieved message:"+msg);

        try {
            HashMap data = null;
            try {
                data=objectMapper.readValue(msg, HashMap.class);

            } catch (IOException e) {
                e.printStackTrace();
            }

            assert data != null;

            int product_id= Integer.valueOf((String) data.get("product_id")) ;

            GetProductEditDTO result_data = productService.getProductAndSku(product_id);

            if (Objects.equals(result_data, null)) {

                logger.error(String.format("查找的product_id不存在,更新缓存失败 msg：%s",msg));
            }
            else {
                String redis_key= (String) data.get("redis_key");

                redisTemplate.opsForValue().set(redis_key,result_data);
                logger.info(String.format("更新缓存%s成功，",redis_key));
            }

        } catch (Exception e) {
            logger.error("异常原因更新缓存失败",e);
        }
    }

}
