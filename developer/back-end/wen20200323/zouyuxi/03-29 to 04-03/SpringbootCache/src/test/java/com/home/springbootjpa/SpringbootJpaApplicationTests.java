package com.home.springbootjpa;

import com.home.springbootjpa.bean.User;
import com.home.springbootjpa.dao.UserMapper;
import com.home.springbootjpa.service.UserService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootJpaApplicationTests {
    @Autowired
    DataSource datesource;
    @Autowired
    UserService userService;
    @Autowired
    UserMapper mapper;


    //测试连接池是否配置成功
    @Test
    public void contextLoads() throws SQLException {
        System.out.println(datesource.getClass());
        Connection connection = datesource.getConnection();
        System.out.println(connection);
    }

    @Test
    public void getUser() {
        User user = userService.queryById(2);
        System.out.println(user.getUserName());
        /**利用断言判断抽取出来的用户是否是李军
         只有在断言为true才会运行后面的代码
         */
        Assert.assertEquals("李军", user.getUserName());
        System.out.println("你好，我是李军！");

    }

    @Test
    @Transactional  //让Spring在@Before 和 @After之间增加事务
    @Rollback   //为了测试类不影响其他测试结果，此处在方法级别上回滚
    public void rollbackTest() {
        User user = new User();
        //先插入一个用户
        user.setUserName("张无忌");
        user.setAge(19);
        boolean b;
        try {
            userService.insertUser(user);
            b = true;
        } catch (Exception e) {
            b = false;
        }
        Assert.assertEquals(true, b);
        System.out.println("插入成功");

        //判断是否影响到数据库
        boolean b1 = mapper.equals(user);
        Assert.assertEquals(false, b1);
        System.out.println("数据库不存在该对象，回滚成功");
    }

    @Test
    public void test() {
        User user = new User();
        user.setUserName("张翠山");
        user.setAge(45);
        User user1 = userService.insertUser(user);
        System.out.println(user1);
    }

    @Test
    public void outTest() {
        List<User> list = userService.queryAll();
        System.out.println(list);

    }

}
