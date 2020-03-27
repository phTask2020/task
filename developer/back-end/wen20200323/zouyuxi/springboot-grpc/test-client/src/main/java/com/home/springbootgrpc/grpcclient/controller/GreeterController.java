package com.home.springbootgrpc.grpcclient.controller;


import com.home.springbootgrpc.grpcclient.service.GreeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: 邹玉玺
 * @date: 2020/3/24-13:54
 */
@Controller//需要访问页面 使用controller
public class GreeterController {
    @Autowired
    private GreeterService greeterService;

    //只读，使用get（更新：put; 创建：post; 删除：delete）
    @GetMapping("/Greeter")
    public String printMessage(@RequestParam("name") String name, HttpServletRequest request){
    //    System.out.println(1);
        String message = greeterService.sendMessage(name);
        //将欢迎信息存放在域对象里
        request.getSession().setAttribute("message",message);
        System.out.println(message);
        return "Greeter";
    }
}
