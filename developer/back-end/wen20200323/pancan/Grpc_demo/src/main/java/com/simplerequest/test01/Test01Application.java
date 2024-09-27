package com.simplerequest.test01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Test01Application {

    public static void main(String[] args) {
        SpringApplication.run(Test01Application.class, args);
    }
    @RequestMapping(value = "/",method = RequestMethod.GET)
    String Hello(){
        return "hello";
    }

}
