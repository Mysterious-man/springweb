package com.acghome.service.cron;

import com.acghome.controller.MallController;
import com.acghome.entity.db1.Mall;
import com.acghome.entity.db1.MallExample;
import com.acghome.mapper.db1.MallMapper;
import com.acghome.service.impl.MallServiceimpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author tmh
 * @version 1.0.0
 * @ClassName ProductScheduled.java
 * @Description TODO
 * @createTime 2019年09月21日 11:38:00
 */


/**
 * 定时执行注解参数
 * 0 0 3 * * ?         每天 3 点执行
 * 0 5 3 * * ?         每天 3 点 5 分执行
 * 0 5 3 ? * *         每天 3 点 5 分执行
 * 0 5/10 3 * * ?      每天 3 点 5 分，15 分，25 分，35 分，45 分，55 分这几个点执行
 * 0 10 3 ? * 1        每周星期天的 3 点10 分执行，注：1 表示星期天
 * 0 10 3 ? * 1#3      每个月的第三个星期的星期天 执行，#号只能出现在星期的位置
 *
 *
 * */



@Component
public class ProductScheduled {

    private final static Logger logger = LoggerFactory.getLogger(ProductScheduled.class);



    @Autowired
    MallMapper mallMapper;





    //指定时间执行过期商品下架的任务
    @Scheduled(cron = "0 5 15 * * ?")
    public void takeProductOff() {

        logger.info("执行定时任务");

        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.HOUR,0);
        ca.set(Calendar.MINUTE,0);
        ca.set(Calendar.SECOND,0);
        Date todaytime = ca.getTime();


        MallExample mallExample = new MallExample();

        mallExample.or()
                    .andPublishStatusEqualTo(1)
                    .andAuditStatusEqualTo(1)
                    .andTypeEqualTo(1)
                    .andExpireTimeLessThanOrEqualTo(todaytime);

        Mall mall = new Mall();
        mall.setPublishStatus(2);
        mallMapper.updateByExampleSelective(mall,mallExample);


    }



//
//    //间隔执行
//    //表示 每隔 15000 毫秒执行一次
//    @Scheduled(fixedRate = 15000)
//    public void reportCurrentTime() {
//
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//        logger.info("每隔十五秒钟执行一次： " + simpleDateFormat.format(new Date()));
//    }


}
