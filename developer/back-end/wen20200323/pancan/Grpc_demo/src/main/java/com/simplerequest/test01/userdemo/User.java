package com.simplerequest.test01.userdemo;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "usertable")
@Component
public class User {

    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String user;
    private String psword;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPsword() {
        return psword;
    }

    public void setPsword(String psword) {
        this.psword = psword;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "user{" +
                "id='" + id + '\'' +
                ", user='" + user + '\'' +
                ", psword='" + psword + '\'' +
                '}';
    }
}
