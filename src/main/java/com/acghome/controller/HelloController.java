package com.acghome.controller;

import com.acghome.service.IMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private IMoneyService moneyService;


    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }


    @RequestMapping("test")
    public Object test(){

        return moneyService.getMoneyById(2);


    }
    private void nb(){  }


}