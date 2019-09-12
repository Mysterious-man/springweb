package com.tmh.webdemo;
import com.acghome.entity.db1.User;
import com.acghome.mapper.db1.UserMapper;
import com.acghome.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebdemoApplicationTests.class)
public class WebdemoApplicationTests {
    @Autowired
    private IUserService userMapper;

    @Test
    public void contextLoads() {
        User rush0 = userMapper.getUser("qwert0");
        System.out.println(rush0.getPassWord());
        System.out.println(rush0.getUserName());
    }

}
