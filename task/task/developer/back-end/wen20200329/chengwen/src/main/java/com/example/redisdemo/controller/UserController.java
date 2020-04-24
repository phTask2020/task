package com.example.redisdemo.controller;


import com.example.redisdemo.bean.User;
import com.example.redisdemo.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/manage")
@Scope("prototype")
public class UserController {

@Autowired
private UserService userService;

@RequestMapping(value="user/login",produces = "application/json;charset=UTF-8",method = RequestMethod.POST)
    @ResponseBody
    public boolean loginUser(Integer id){
    User user=new User();
    user.setId(id);
    return userService.loginUser(user);
}


}
