package com.home.springbootjpa.controller;

import com.home.springbootjpa.bean.User;
import com.home.springbootjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

/**
 * @author: 邹玉玺
 * @date: 2020/3/18-22:23
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;

    //增加用户
    @PostMapping("/user")
    public String addUser(User user, HttpServletRequest request) {
        userService.insertUser(user);
        request.getSession().setAttribute("users", user);
        //跳转到查询所有页面，可以看到插入的对象
        return "redirect:/users";
    }

    //删除用户
    @DeleteMapping("/user/{id}")
    public String deleteById(@PathVariable("id") Integer id) {
        System.out.println(id);

       userService.deleteById(id);

        return "redirect:/users";
    }

    //修改用户信息
    @PutMapping("/user")
    public String updateUser(User user,HttpServletRequest Request) {
        userService.updateUser(user);
        Request.getSession().setAttribute("users",user);

        return "redirect:/users";
    }

    //查询所有成员信息
    @GetMapping("/users")
    public String userList(HttpServletRequest request) {
//查出所有成员
        List<User> list = userService.queryAll();
        //放到请求域中
        request.getSession().setAttribute("users", list);

        return "list";
    }

    //来到员工添加页面
    @GetMapping("/user")
    public String toAddPage() {
        //返回到添加页面
        return "add";
    }

    //来到员工修改页面
    @GetMapping("/user/{id}")
    public String toEditPage(@PathVariable("id") Integer id,HttpServletRequest request) {
        User user = userService.queryById(id);
        request.getSession().setAttribute("user",user);
        //返回到修改页面
        return "update";
    }
    //跳转到删除页面
    @GetMapping("/userdel")
    public String toDeletePage(HttpServletRequest request){
        return "delete";
    }


    @ResponseBody
    @GetMapping("/getuser/{id}")
    public User findById(@PathVariable("id") Integer id){
        System.out.println(id+"controller");
        User user = userService.queryById(id);
        return user;
    }
}
