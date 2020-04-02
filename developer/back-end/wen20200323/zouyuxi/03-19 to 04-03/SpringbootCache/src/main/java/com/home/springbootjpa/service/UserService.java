package com.home.springbootjpa.service;

import com.home.springbootjpa.bean.User;

import java.util.List;
import java.util.Map;

/**
 * @author: 邹玉玺
 * @date: 2020/3/18-22:24
 */
public interface UserService {
    //增加用户
    User insertUser(User user);

    //根据ID删除用户
    void deleteById(Integer id);

    //修改用户信息
    User updateUser(User user);

    //根据用户ID查询
    User queryById(Integer id);

    //查询所有用户信息
    List<User> queryAll();
}
