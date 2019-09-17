package com.acghome.controller;

import com.acghome.controller.mq.Producer;
import com.acghome.service.IMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private IMoneyService moneyService;

    @Autowired
    Producer producer;


    @RequestMapping("/hello")
    public String index() {

        for (int i = 0; i <5 ; i++) {

            Integer product_id=5;
            String product_key="GetProductAndSkuEdit_product_id_"+product_id.toString();

            producer.productChangeSend(product_key,product_id);

        }

        return "Hello World";


    }


    @RequestMapping("test")
    public Object test(){

        return moneyService.getMoneyById(2);


    }


}