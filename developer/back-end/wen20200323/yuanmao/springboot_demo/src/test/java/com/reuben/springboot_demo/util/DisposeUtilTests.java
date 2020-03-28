package com.reuben.springboot_demo.util;

import com.reuben.entity.User;
import com.reuben.springboot_demo.SpringbootDemoApplicationTests;
import com.reuben.util.DisposeUtil;
import org.junit.Test;

/**
 * @program: springboot_demo
 * @description:
 * @author: reuben
 * @create: 2020-03-20 19:30
 **/
public class DisposeUtilTests extends SpringbootDemoApplicationTests {
    private DisposeUtil disposeUtil;
    @Test
    public void ts(){
        User user = new User("a", "a", "a");
        Object dispose = DisposeUtil.dispose(user);
        System.out.println(dispose);
    }
}
