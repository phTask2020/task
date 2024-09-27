package com.simplerequest.test01;


import com.simplerequest.test01.userdemo.User;
import com.simplerequest.test01.userdemo.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class UserServiceTests {

    @Autowired
    UserServiceImpl usi;

    @Test
    public void findTest(){
        Assert.assertEquals(5,usi.findById(5).getId());
    }


    @Test
    @Rollback
    public void deleteTest(){
        usi.delete(5);
       // Assert.assertFalse("删除失败",usi.findById(5)==null);
        Assert.assertTrue("删除成功",usi.findById(5)==null);

    }

    @Test
    @Rollback
    public void addTest(){
        User user = new User();
        user.setUser("qwer");
        user.setPsword("159753");
        Assert.assertEquals(user,usi.add(user));
    }
}
