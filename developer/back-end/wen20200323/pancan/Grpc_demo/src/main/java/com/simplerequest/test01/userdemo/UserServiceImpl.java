package com.simplerequest.test01.userdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServiceImpl implements UserSerice {
    @Autowired
    private UserDao userDao;
    @Override
    public User findById(int id) {
        Optional<User> optionalUser  = userDao.findById(id);
        System.out.println(optionalUser);
        if (optionalUser.isPresent())
            return optionalUser.get();
        else
            return null;
    }

    @Override
    public void delete(int id) {
        userDao.deleteById(id);
    }

    @Override
    public User add(User user) {
        User user1 = userDao.save(user);
        return user1;
    }

    @Override
    public User update(User user) {
        User user1 = userDao.save(user);
        return user1;
    }
}
