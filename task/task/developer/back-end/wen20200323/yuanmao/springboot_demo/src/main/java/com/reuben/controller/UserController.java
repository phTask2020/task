package com.reuben.controller;

import com.reuben.entity.PageParam;
import com.reuben.entity.User;
import com.reuben.service.UserService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController("api")
@Api(tags = "User相关api")
@Validated
@Slf4j
public class UserController {
    @Autowired
    private User user_default;

    @Autowired
    private UserService userService;

    @PostMapping("/post_test")
    @ApiOperation(value = "post提交User", notes = "需要User作为参数", httpMethod = "POST")
    public String testPost(@ApiParam(value = "userName:用户名、userPassword:密码", required = true)
                           @RequestBody User user) {
        System.out.println(user);
        return "Success! Hello!" + user.getUserName() + ",your password is:" + user.getUserPassword();
    }

    @GetMapping("/default_user")
    @ApiOperation(value = "获取默认user", notes = "无需参数", httpMethod = "GET")
    public User getDefaultUser() {
        return user_default;
    }


    @PostMapping("user")
    @ApiOperation(value = "添加User", notes = "新建用户", httpMethod = "POST")
    public String saveUser(@RequestBody User user) {
        //User user = new User(userName, userPassword, userEmail);
        return userService.save(user);
    }

    @GetMapping("user/all_users")
    @ApiOperation(value = "获取所有User", notes = "无需参数", httpMethod = "GET")
    public String getAllUser() {
        return userService.getAll();
    }

    @GetMapping("user/{userName}")
    @ApiOperation(value = "通过userName获取User", notes = "需要userName作为参数", httpMethod = "GET")
    public String findByUserName(@ApiParam(name = "userName", value = "用户名", required = true, example = "reuben")
                                 @PathVariable String userName) {
        return userService.getByUserName(userName);
    }


    @GetMapping("user")
    @ApiOperation(value = "通过userId获取User", notes = "需要userId作为参数", httpMethod = "GET")
    public String findByUserId(Integer id) {
        //log.info(id.toString());
        return userService.getByUserId(id);
    }

    @DeleteMapping("user")
    @ApiOperation(value = "通过id删除User", notes = "需要id作为参数", httpMethod = "DELETE")
    public String deleteUserById(@ApiParam(value = "用户id", required = true)
                               @RequestBody Integer id) {
        return userService.deleteByUserId(id);
    }

    @DeleteMapping("/deletions")
    @ApiOperation(value = "通过id批量删除User", notes = "需要id作为参数", httpMethod = "DELETE")
    public String multipleDeleteByUserId(@ApiParam(value = "用户id", required = true)
                                         @RequestBody  List<Integer> ids) {
        return userService.multipleDeleteByUserId(ids);
    }

    @PutMapping("user")
    @ApiOperation(value = "修改User", notes = "需要User作为参数", httpMethod = "PUT")
    public String update(@ApiParam(value = "userId:id、userName:用户名、userPassword:密码、email:邮箱", required = true)
                         @RequestBody User user) {
        return userService.update(user);
    }

    @GetMapping("/pagination")
    @ApiOperation(value = "条件查询（分页）", notes = "无条件时，参数留空（需要id查询请使用findByUserId)", httpMethod = "GET")
    public Page<User> findByPage(@ApiParam(value = "无条件时，参数留空（需要id查询请使用findByUserId)", required = true)
                                 @RequestBody PageParam pageParam) {
        return userService.getByPage(pageParam);
    }


}
