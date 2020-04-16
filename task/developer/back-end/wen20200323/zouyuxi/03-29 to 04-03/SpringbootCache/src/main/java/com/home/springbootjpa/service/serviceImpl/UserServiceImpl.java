package com.home.springbootjpa.service.serviceImpl;

import com.home.springbootjpa.bean.User;
import com.home.springbootjpa.dao.UserMapper;
import com.home.springbootjpa.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 邹玉玺
 * @date: 2020/3/18-22:25
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
   private UserMapper userMapper;
    private static final Logger log= LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    @CachePut(value = "user",key = "#user.id.toString()")
    public User insertUser(User user) {
        User u = userMapper.save(user);
        log.info("为id、key为："+u.getId()+"的数据做了缓存");
      return u;
        //增加用户
    }

    @Override
    @CacheEvict(value = "user",key = "#id.toString()")
    public void deleteById(Integer id) {
        //根据ID删除用户
        userMapper.deleteById(id);
        log.info("删除了id、key为："+id+"的数据缓存");
    }

    @Override
    @CachePut(value = "user",key = "#user.id.toString()")
    public User updateUser(User user) {
        User u = userMapper.saveAndFlush(user);
        //修改用户信息
        log.info("为id、key为："+(u==null?"null":u.getId())+"的数据做了缓存");
        return u;
    }

    @Override
    @Cacheable(value = "user")
    public User queryById(Integer id) {
        //根据用户ID查询
        System.out.println(id+"impl");
        User u = userMapper.getOne(id);
        log.info("为id、key为："+(u==null?"null":u.getId())+"的数据做了缓存");
        return u;
    }

    @Override
    @Cacheable(value = "list")
    public List<User> queryAll() {
        //查询所有用户信息
        List<User> list = userMapper.findAll();
        return list;
    }


}
