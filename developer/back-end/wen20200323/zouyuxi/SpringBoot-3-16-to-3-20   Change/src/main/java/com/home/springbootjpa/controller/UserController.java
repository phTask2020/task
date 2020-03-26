package com.home.springbootjpa.controller;

import com.home.springbootjpa.bean.User;
import com.home.springbootjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: 邹玉玺
 * @date: 2020/3/18-22:23
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    //增加用户
    @PostMapping("/insert")
    public  Map<String, Object> insertUser(User user) {
        Map<String,Object> map=new HashMap<>();
        try {
            userService.insertUser(user);
            map.put("success",true);
            map.put("message","添加成功");
            map.put("result","");
            map.put("code",user);
        } catch (Exception e) {
            map.put("success",false);
            map.put("message","删除失败");
            map.put("result","");
            map.put("code","");

        }
        return map;//返回所增加的用户信息
    }

    //删除用户
    @DeleteMapping("/delete")
    public Map<String, Object> deleteById(@PathVariable("id") Integer id) {
        Map<String,Object> map=new HashMap<>();
        try {
            userService.deleteById(id);
            map.put("success",true);
            map.put("message","删除成功");
            map.put("result","");
            map.put("code","");
            map.put("timestamp","");
        } catch (Exception e) {
            map.put("success",false);
            map.put("message","删除失败");
            map.put("code","");
            map.put("result","");
            map.put("timestamp","");
        }

        return map;
    }

    //修改用户信息
    @PutMapping("/update")
    public Map<String, Object> updateUser(User user) {
        Map<String,Object> map=new HashMap<>();
        try {
            userService.updateUser(user);
            map.put("success",true);
            map.put("message","修改成功");
            map.put("code","");
            map.put("timestamp","");
            map.put("result","");
        } catch (Exception e) {
            map.put("success",false);
            map.put("message","修改失败");
            map.put("code","");
            map.put("timestamp","");
            map.put("result","");
        }

        return map;
    }

    //根据ID查询用户信息
    @GetMapping("/queryById")
    public Map<String, Object> queryById(@PathVariable("id") Integer id) {
        Map<String,Object> map=new HashMap<>();
        try {
            User user = userService.queryById(id);
            map.put("success",true);
            map.put("message","查询成功");
            map.put("result",user);
            map.put("code","");
            map.put("timestamp","");
        } catch (Exception e) {
            map.put("success",false);
            map.put("message","查询失败");
            map.put("result","");
            map.put("code","");
            map.put("timestamp","");
        }


        return map;
    }
      //查询所有成员信息
    @GetMapping("/queryAll")
    public Map<String, Object> queryAll(){
        Map<String,Object> map=new HashMap<>();
        try {
            List<User> list = userService.queryAll();
            map.put("success",true);
            map.put("message","查询成功");
            map.put("code","");
            map.put("timestamp","");
            map.put("result",list);
        } catch (Exception e) {
            map.put("success",false);
            map.put("message","查询成功");
            map.put("code","");
            map.put("timestamp","");
            map.put("result","");
        }

        return map;
    }

}
