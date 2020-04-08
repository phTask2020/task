package com.example.demo;

/*
静态方法调用静态方法
 */
public class Test {

    public void IsUser1(){
        System.out.println("你成功调用了非静态方法的用户");
    }

    public static void main(String[] args) {
        Test user1 = new Test();
        user1.IsUser1();
        User user = new User();
        user.IsUser();
    }

}
