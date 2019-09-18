package com.acghome.conf;

/**
 * @author tmh
 * @version 1.0.0
 * @ClassName RabbitConfig.java
 * @Description Rabbitmq配置
 * @createTime 2019年09月16日 18:10:00
 */

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitConfig {

    /**
     * 定义队列名
     */
    //用于产品和sku信息变更时发送消息
    public final static String PRODUCT_INFO_1 = "ProductAndSkuUpdate";



    /**
     * 定义队列
     *
     * @return
     */
    @Bean(name = PRODUCT_INFO_1)
    public Queue queue1() {
        return new Queue(PRODUCT_INFO_1);
    }



}