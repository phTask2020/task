package com.example.redisdemo.service;

import com.example.redisdemo.bean.User;


import java.io.Serializable;

public interface UserService {
    public User getById(Integer id);
    public boolean removeById(Integer id);

    boolean loginUser(User user);
}
