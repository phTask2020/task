package com.home.grpctest;

import com.home.grpc.usertestlib.Person;

/**
 * @author: 邹玉玺
 * @date: 2020/3/25-14:34
 */
public class uerTest {

    public static void main(String[] args) {
        //获取Student对象
        //这里的Student对象构造器被私有化,我们通过Student的内部类Builder来构建builder
        Person.Student.Builder builder = Person.Student.newBuilder();
        //通过Student的内部类builder提供了构建Student相关属性的set方法

    }

}
