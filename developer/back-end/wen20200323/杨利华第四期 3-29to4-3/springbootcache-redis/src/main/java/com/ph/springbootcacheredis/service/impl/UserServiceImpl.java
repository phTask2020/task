package com.ph.springbootcacheredis.service.impl;


import com.ph.springbootcacheredis.mapper.UserMapper;
import com.ph.springbootcacheredis.pojo.UserPOJO;
import com.ph.springbootcacheredis.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @description:
 * @author: 杨利华
 * @date: 2020/3/30
 */
@Service
public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    UserMapper userMapper;


    @Override
    @CachePut(value = "user",key = "#userPOJO.id.toString()")
    public UserPOJO save(UserPOJO userPOJO) {
        UserPOJO user = userMapper.save(userPOJO);
        return user;
    }

    @Override
    @Cacheable(value = "user",key = "#id")
    public UserPOJO userPOJOFindById(Integer id) {
        UserPOJO user=userMapper.getOne(id);
        return user;
    }

    @Override
    @CachePut(value = "user",key = "#userPOJO.id.toString()")
    public UserPOJO changeUserPOJO(UserPOJO userPOJO) {
        UserPOJO user=userMapper.saveAndFlush(userPOJO);
        return user;
    }

    @Override
    @CacheEvict(value = "user",key = "#id")
    public void deleteUserPOJO(int id) {
        userMapper.deleteById(id);
    }

    @Override
    public List<UserPOJO> userFindAll() {
        return userMapper.findAll();
    }

    @Override
    @Cacheable(cacheNames = "list")
    public List<UserPOJO> redisList(){
        return userMapper.findAll();
    }

    @Override
    @Cacheable(cacheNames = "set")
    public Set<UserPOJO> redisSet(){
        Set<UserPOJO> set=new HashSet<>();
        List<UserPOJO> list=userFindAll();
        for (UserPOJO pojo:list) {
            set.add(pojo);
        }
        return set;
    }
}
