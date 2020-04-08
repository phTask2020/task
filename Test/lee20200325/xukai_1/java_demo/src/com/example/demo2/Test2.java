package com.example.demo2;

import com.example.demo.Test;

/*
非静态方法在同一类调用其他方法
 */
public class Test2 {
    public void User1(){
        System.out.println("你成功调用了非静态方法中的用户1");
    }
    public static void User2(){
        System.out.println("你成功调用了静态方法里的用户2");
    }
    public void alloutput(){
        User1();
        User2();
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.alloutput();}
}
