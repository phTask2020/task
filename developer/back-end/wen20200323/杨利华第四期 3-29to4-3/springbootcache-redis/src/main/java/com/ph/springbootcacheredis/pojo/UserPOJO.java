package com.ph.springbootcacheredis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @description:
 * @author: 杨利华
 * @date: 2020/3/30
 */
@Data   //相当于加入getset方法
@AllArgsConstructor  //全参构造方法
@ToString   //重写tostring方法，引入Lombok简化代码
@Entity
@Table(name = "student")
public class UserPOJO implements Serializable {

    public UserPOJO() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private  String name;

    private  String gender;

}
