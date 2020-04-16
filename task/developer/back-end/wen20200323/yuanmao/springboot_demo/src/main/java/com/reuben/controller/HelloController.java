package com.reuben.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(tags = "HelloController")
public class HelloController {
    @GetMapping("/hello")
    @ApiOperation(value = "简单get请求",notes = "no param",httpMethod = "GET")
    public String hello() {
        return "hello";
    }
}
