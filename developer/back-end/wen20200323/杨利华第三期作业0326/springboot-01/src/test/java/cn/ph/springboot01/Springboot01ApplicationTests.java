package cn.ph.springboot01;


import cn.ph.springboot01.userBean.Student;
import cn.ph.springboot01.userMapper.UserMapper;
import cn.ph.springboot01.userService.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

/**
 * 可以再测试期间很方便的类似编码一样进行自动注入等容器功能
 */
@RunWith(SpringRunner.class)       //单元测试用spring驱动器来运行，就不是用原来的junit测试
@SpringBootTest      //springboot单元测试
@Transactional      //事务注解 在sping添加事务
public class Springboot01ApplicationTests {

    @Autowired
    Student student;

    @Autowired
    UserService userservice;

    @Autowired
    UserMapper usermapper;


    //配置文件赋值测试
    @Test
    public void contextLoads() {
        System.out.println(student);
    }


    @Test
    public void asserttest() {
        Student p = userservice.queryById(1);
        //测试对象是否为空 为空不往下运行
        Assert.assertNotNull(p);

        System.out.println("Assert断言测试");
        System.out.println(p.getId() + "=" + p.getName() + "=" + p.getGender());
    }

    @Test
    @Rollback   //事务回滚
    public void rollbacktest() {
        Student p1 = new Student();
        p1.setName("一giao我里giaogiao");
        p1.setGender("男");
        //向数据库中添加对象
        boolean b;
        try {
            userservice.add(p1);
            b = true;
        } catch (Exception e) {
            b = false;
        }
        Assert.assertEquals(true, b);
        //当b=true时数据添加成功
        System.out.println("事务不回滚");
    }

    //断言测试
    @Test
    public void testassert01() {
        int x = 10;
        System.out.println("Testing Assertion that x==100");
        assert x == 10 : "Out assertion failed!";
        System.out.println("Test passed!");


    }

}