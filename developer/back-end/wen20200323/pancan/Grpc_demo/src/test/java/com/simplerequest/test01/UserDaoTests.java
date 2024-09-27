package com.simplerequest.test01;

import com.simplerequest.test01.userdemo.User;
import com.simplerequest.test01.userdemo.UserDao;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
class UserDaoTests {
    @Autowired
    UserDao userDao;

    @Test
    void daoFindTest() {
//        List<User> all = userDao.findAll();
//        System.out.println(all);
        Assert.assertEquals(5,userDao.findAll().size());
    }

    @Test
    @Rollback
    void daoAddTest(){
        User user = new User();
        user.setUser("yuanmao");
        user.setPsword("1234567");
        Assert.assertEquals(user,userDao.save(user));
    }

    @Test
    @Rollback
    void daoDeleteTest(){
        userDao.deleteById(5);
        Assert.assertTrue("删除成功",userDao.findById(5)==null);
    }

}
