package com.example.demo3;

import com.example.demo.User;

/*
非静态方法在不同类之间调用其他方法
 */
public class Test3 {
    public void output(){
        User3.IsUser3();
        User3 user3 = new User3();
        User3.IsUser4();
    }

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        test3.output();
    }
}
