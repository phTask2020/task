package com.example.redisdemo.service.impl;

import com.example.redisdemo.bean.User;
import com.example.redisdemo.service.UserService;
import com.example.redisdemo.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    RedisUtils redisUtils;
    @Cacheable(value = "usr" , key = "#root.args[0]" , condition = "#id > 0" , unless = "#result eq null")
    @Override
    public User getById(Integer id) {
        System.out.println("get by id");
        if (!redisUtils.hasKey(""+id)){
            return null;
        }User getUser= (User) redisUtils.get(""+id);
        return getUser;
    }
    @Cacheable(value = "usr" , key = "#root.args[0]" , condition = "#result eq true " )
    @Override
    public boolean removeById(Integer id) {
        redisUtils.del(""+id);
        if (redisUtils.hasKey(""+id))
            return false;
        return true;
    }

    @Override
    public boolean loginUser(User user) {
        if (redisUtils.hasKey(""+user.getId()))
            return true;
        return false;
    }
}
