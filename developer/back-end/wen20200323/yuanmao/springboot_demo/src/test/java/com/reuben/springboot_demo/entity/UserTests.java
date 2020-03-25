package com.reuben.springboot_demo.entity;

import com.reuben.entity.User;
import com.reuben.springboot_demo.SpringbootDemoApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: springboot_demo
 * @description: User unit tests
 * @author: reuben
 **/
@Slf4j
public class UserTests extends SpringbootDemoApplicationTests {

    @Autowired
    private User user_default;

    @Test
    public void test_toString() {
        Assert.assertEquals("default_userName",
                user_default.getUserName());
        //log.info(user_default.toString());
    }
}
