package com.ph.springbootcacheredis.controller;

import com.ph.springbootcacheredis.pojo.UserPOJO;
import com.ph.springbootcacheredis.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;


/**
 * @description:
 * @author: 杨利华
 * @date: 2020/3/30
 */
@Controller
public class UserController {

    @Autowired
    UserServiceInterface userServiceInterface;

    //尝试把数据返回页面
    @GetMapping("/studentTable")
    public String list(Model model) {

        List<UserPOJO> userPOJOS = userServiceInterface.userFindAll();

        //加入redis的list
        userServiceInterface.redisList();
        //加入redis的set
        userServiceInterface.redisSet();

        model.addAttribute("students", userPOJOS);
        return "list";
    }

    //来到员工添加页面
    @GetMapping("/add")
    public String add() {
        return "Add";
    }

    //添加员工
    @PostMapping("/addStudent")
    public String addStudent(UserPOJO userPOJO) {
        userServiceInterface.save(userPOJO);
        //redirect:重定向到一个地址 /代表当前目录
        //forward：转发到一个地址
        return "redirect:/studentTable";
    }

    //来到修改页面
    @GetMapping("/change/{id}")
    public String change(@PathVariable("id") Integer id, Model model) {
        //由ID查出学生
        UserPOJO userPOJO = userServiceInterface.userPOJOFindById(id);
        //用于修改回显
        model.addAttribute("student", userPOJO);

        //修改添加二合一页面
        return "Add";
    }

    //修改员工
    @PutMapping("/addStudent")
    public String changeStudent(UserPOJO userPOJO) {

        userServiceInterface.changeUserPOJO(userPOJO);

        return "redirect:/studentTable";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        userServiceInterface.deleteUserPOJO(id);
        return "redirect:/studentTable";
    }
}
