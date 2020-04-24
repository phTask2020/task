package com.reuben.springboot_demo;


import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringbootDemoApplicationTests {
    protected MockMvc mvc;
    @Autowired
    private WebApplicationContext context;

    @Before
    public void init() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();//构造MockMvc
        log.info("--------start testing------");
    }

    @After
    public void after() {
        log.info("--------End of test--------");
    }


}
