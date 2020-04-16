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
    public void insertUser(User user);

    //根据ID删除用户
    public void deleteById(Integer id);

    //修改用户信息
    public void updateUser(User user);

    //根据用户ID查询
    public User queryById(Integer id);

    //查询所有用户信息
    public List<User> queryAll();
}
