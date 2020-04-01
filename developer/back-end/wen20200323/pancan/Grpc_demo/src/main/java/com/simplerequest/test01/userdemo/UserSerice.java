package com.simplerequest.test01.userdemo;

public interface UserSerice {
    User findById(int id);
    void delete(int id);
    User add(User user);
    User update(User user);
}
