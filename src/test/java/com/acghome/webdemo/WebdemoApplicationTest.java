package com.acghome.webdemo;

import com.acghome.service.IProductService;
import com.acghome.service.mq.Producer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class WebdemoApplicationTest {


    @Autowired
    private IProductService productService;

//    @Autowired
//    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private Producer producer;

    @Test
    public void testStringSend() {

        for (int i = 0; i <5; i++) {
            String  product_id=String.valueOf(5);
            String product_key="GetProductAndSkuEdit_product_id_"+ product_id;

            producer.productChangeSend(product_key,product_id);

        }


    }




    @Test
    public void sayHelloTest() {
        System.out.println("test start");
    }


//    @Test
//    public void productTest() {
//        Product product = productService.getProductById(1);
//        System.out.println(product.getProductName());
//    }


//    @Test
//    public void addTest() {
//        //这里相当于redis对String类型的set操作
//        redisTemplate.opsForValue().set("test","newrush");
//        //这里相当于redis对String类型的get操作
//        String test = (String)redisTemplate.opsForValue().get("test");
//        System.out.println(test);
//    }




}
