package com.example.demo1;


/*
非静态方法调用其他方法
 */
public class Test1 {

    public static void IsUser2(){
        System.out.println("你成功调用了静态方法里的用户2");
    }
    public static void main(String[] args) {
        IsUser2();
        User1.IsUser3();
    }
}
