package com.reuben.springboot_demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reuben.entity.User;
import com.reuben.springboot_demo.SpringbootDemoApplicationTests;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 **/
@Slf4j
@Transactional//默认回滚，@Rollback(false)取消回滚
public class UserControllerTests extends SpringbootDemoApplicationTests {
    @Autowired
    private User user_default;

    private ObjectMapper mapper = new ObjectMapper();//jackson

    private MockHttpServletRequestBuilder content = null;//构造请求

    private User test_user = new User("test", "test", "test@mail.cn");
    //json格式的User
    private static String user_json;

    {
        try {
            user_json = mapper.writeValueAsString(test_user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


    @SneakyThrows
    @Test
    public void test_testPost() {
        content = MockMvcRequestBuilders.post("/post_test")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(user_json);
        MvcResult mvcResult = mvc.perform(content).andReturn();
        //log.info(mvcResult.getResponse().getContentAsString());
        String expect = "Success! Hello!"
                + test_user.getUserName()
                + ",your password is:"
                + test_user.getUserPassword();
        Assert.assertEquals(expect, mvcResult.getResponse().getContentAsString());

    }

    @SneakyThrows
    @Test
    public void test_getDefaultUser() {
        String contentAsString = mvc.perform(MockMvcRequestBuilders.get("/default_user"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
        //log.info(contentAsString);
        String expect = mapper.writeValueAsString(user_default);
        Assert.assertEquals(expect, contentAsString);
    }

    @SneakyThrows
    @Test
    public void test_addUser() {
        content = MockMvcRequestBuilders.post("/user")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(user_json);
        //log.info(content.toString());
        MvcResult mvcResult = mvc.perform(content).andReturn();
        //log.info(mvcResult.getResponse().getContentAsString());
        Assert.assertEquals("save Success",
                mvcResult.getResponse().getContentAsString());
    }

    @SneakyThrows
    @Test
    public void test_getAllUser() {
        content = MockMvcRequestBuilders.get("/user/all_users")
                .contentType(MediaType.APPLICATION_JSON_UTF8);
        MvcResult mvcResult = mvc.perform(content).andReturn();
        //log.info(mvcResult.getResponse().getContentAsString());
        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(200, status);
        Assert.assertTrue(mvcResult.getResponse().getContentLength() > 0);
    }

    @SneakyThrows
    @Test
    public void test_findByUserName() {
        String userName = "da";
        content = MockMvcRequestBuilders.get("/user/{userName}", userName)
                .contentType(MediaType.APPLICATION_JSON_UTF8);

        MvcResult mvcResult = mvc.perform(content).andReturn();
        //log.info(mvcResult.getResponse().getContentAsString());
        Assert.assertTrue(mvcResult.getResponse().getContentLength() > 0);

    }

    @SneakyThrows
    @Test
    public void test_deleteUserById() {
        MockHttpServletRequestBuilder delete = MockMvcRequestBuilders.delete("/user", 1);
        MvcResult mvcResult = mvc.perform(delete).andReturn();
        log.info(mvcResult.toString());
        Assert.assertTrue(HttpMessageNotReadableException.class.isAssignableFrom(mvcResult.getResolvedException().getClass()));//错误的请求内容体
    }

    @SneakyThrows
    @Test
    public void test_update() {
        User user = new User();
        user.setUserId(1);
        user.setUserName("test");
        user.setUserPassword("test");
        user.setEmail("test@mail.cn");

        content = MockMvcRequestBuilders.put("/user")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsBytes(user));
        MvcResult mvcResult = mvc.perform(content).andReturn();
        log.info(mvcResult.getResponse().getContentAsString());

    }
}
