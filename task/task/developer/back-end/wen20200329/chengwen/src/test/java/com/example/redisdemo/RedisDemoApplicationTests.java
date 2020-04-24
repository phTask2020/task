package com.example.redisdemo;

import com.example.redisdemo.bean.User;
import com.example.redisdemo.service.UserService;
import com.example.redisdemo.service.impl.UserServiceImpl;
import com.example.redisdemo.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class RedisDemoApplicationTests {
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    UserService userService;
    @Test
    void contextLoads() throws Exception{
        User user=new User(3,"phLink","woman");

        redisUtils.set("3",user);
        boolean exists = redisUtils.hasKey("3");
        System.out.println("是否存在："+exists);
    }

    @Test
    void testService(){
        System.out.println(userService.getById(3));
    }

}
