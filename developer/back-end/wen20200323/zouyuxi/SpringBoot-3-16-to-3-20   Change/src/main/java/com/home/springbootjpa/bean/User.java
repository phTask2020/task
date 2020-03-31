package com.home.springbootjpa.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * @author: 邹玉玺
 * @date: 2020/3/18-21:59
 */
//使用jpa注解配置映射关系
@Entity   //告诉jpa这是一个实体类
@Table(name ="user")    //和哪一张表关联
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class User {
    @Id//这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    private Integer id;
    @Column(name = "userName")
    private String userName;
    @Column(name = "age")//不写默认是属性名
    private Integer age;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}


