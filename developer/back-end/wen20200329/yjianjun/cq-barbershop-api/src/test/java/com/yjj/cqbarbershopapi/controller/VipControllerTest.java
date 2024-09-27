package com.yjj.cqbarbershopapi.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
class VipControllerTest {

    private MockMvc mockMvc;



    @Autowired
    WebApplicationContext webApplicationContext;

    @BeforeEach
    void setUp() {
       mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void list() {
    }

    @Test
    void save() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/vip");
        String contentAsString = mockMvc.perform(builder.
                contentType(MediaType.APPLICATION_JSON).
                param("name", "dashuaibi").
                param("pass", "123465")).
                andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        System.out.println(contentAsString);

    }

    @Test
    void findById() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/vip/3");
        String contentAsString = mockMvc.perform(builder).
                andExpect(status().isOk()).
                andReturn().getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }
}