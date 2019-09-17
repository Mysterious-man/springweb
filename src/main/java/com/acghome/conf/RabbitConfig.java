package com.acghome.conf;

/**
 * @author tmh
 * @version 1.0.0
 * @ClassName RabbitConfig.java
 * @Description TODO
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
    public final static String STRING = "string";



    /**
     * 定义队列
     *
     * @return
     */
    @Bean
    public Queue string() {
        return new Queue(STRING);
    }

//    @Bean
//    public MessageConverter jsonMessageConverter() {
//        return new Jackson2JsonMessageConverter();
//    }


}