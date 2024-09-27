package com.simplerequest.test01;


import com.simplerequest.test01.userdemo.User;
import com.simplerequest.test01.userdemo.UserController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
public class ControllerTests {
    @Autowired
    UserController ucl;

    @Test
    public void findTest(){
        Assert.assertEquals(5,ucl.findUserById(5).getId());
    }

    @Test
    @Rollback
    public void deleteTest(){
        ucl.deleteUserById(5);
        Assert.assertTrue("删除成功",ucl.findUserById(5)==null);
    }

    @Test
    @Rollback
    public void addTest(){
        User user = new User();
        user.setUser("yuanmaomao");
        user.setPsword("159632489");
        Assert.assertEquals(user,ucl.addUser(user));
    }
}
