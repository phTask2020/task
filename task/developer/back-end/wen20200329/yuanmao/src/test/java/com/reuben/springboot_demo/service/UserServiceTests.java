package com.reuben.springboot_demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reuben.entity.PageParam;
import com.reuben.entity.User;
import com.reuben.service.UserService;
import com.reuben.springboot_demo.SpringbootDemoApplicationTests;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: springboot_demo
 * @description:
 * @author: reuben
 * @create: 2020-03-19 14:29
 **/
@Slf4j
@Transactional
public class UserServiceTests extends SpringbootDemoApplicationTests {
    @Autowired
    private UserService userService;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    //@Rollback(false)//默认开启rollback
    public void test_save() {
        User user = new User();
        user.setEmail("test@mail.cn");
        user.setUserName("test");
        user.setUserPassword("test");
        String save = userService.save(user);
        log.info(save);
    }

    @Test
    //@Rollback(false)//默认开启rollback
    public void test_findAll() {
        String all = userService.getAll();
        log.info(all);
    }


    @SneakyThrows
    @Test
    public void test_findByUserName() {
        String s = "reuben";
        String reuben = userService.getByUserName(mapper.writeValueAsString(s));
        log.info(reuben);
    }

    @Test
    //@Rollback(false)//默认开启rollback
    public void test_deleteByUserId() {
        int id = 1;
        String s = userService.deleteByUserId(id);
        log.info(s);
    }

    @Test
    //@Rollback(false)//默认开启rollback
    public void test_update() {
        User user = new User();
        user.setUserId(1);
        user.setEmail("test@mail.cn");
        user.setUserName("test");
        user.setUserPassword("test");
        String update = userService.update(user);
        log.info(update);
    }

    @Test
    public void test_findByPage() {
        PageParam pageParam = new PageParam();

        Page<User> byPage = userService.getByPage(pageParam);
        Assert.assertTrue(byPage.getSize() > 0);
    }

}
