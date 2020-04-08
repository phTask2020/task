package com.example.testng_demo;

import org.testng.annotations.Test;

public class TestDemo {
    public int add(int j,int k){
        int i;
        i = j + k;

        return i;
    }
    @Test
    public  void testadd(){
        if(8==add(4,4)){
            System.out.println("通过验证");
        }
        else {
            System.out.println("验证失败");
        }
    }
}
