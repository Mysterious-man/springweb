package com.acghome.webdemo;
import com.acghome.entity.db1.Product;
import com.acghome.service.IProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringRunner.class)
@SpringBootTest
public class WebdemoApplicationTest {


    @Autowired
    private IProductService productService;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

//    @Test
//    public void productTest() {
//        Product product = productService.getProductById(1);
//        System.out.println(product.getProductName());
//    }


    @Test
    public void addTest() {
        //这里相当于redis对String类型的set操作
        redisTemplate.opsForValue().set("test","newrush");
        //这里相当于redis对String类型的get操作
        String test = (String)redisTemplate.opsForValue().get("test");
        System.out.println(test);
    }


    @Test
    public void sayHelloTest() {
        System.out.println("test start");
    }

}
