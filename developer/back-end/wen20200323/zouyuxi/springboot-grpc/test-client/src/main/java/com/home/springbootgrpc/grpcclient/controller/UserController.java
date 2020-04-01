package com.home.springbootgrpc.grpcclient.controller;


import com.home.grpc.userlib.User;
import com.home.grpc.userlib.UserPublicGrpc;
import com.home.springbootgrpc.grpcclient.service.UserService;
import io.grpc.Channel;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: 邹玉玺
 * @date: 2020/3/25-11:18
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/queryMessageById")
    public String queryMessageById(@RequestParam("id") Integer id, HttpServletRequest request) {
        String message= userService.queryMessageById(id);
        //将查询到的message信息放在域对象里
        request.getSession().setAttribute("message", message);
        return "success";
    }
}
