package com.acghome.controller;


import com.acghome.service.IMoneyService;
import com.acghome.service.mq.Producer;
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


        return "Hello World";


    }


    @RequestMapping("test")
    public Object test(){

        return moneyService.getMoneyById(2);


    }


}