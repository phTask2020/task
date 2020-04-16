package com.reuben.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @program: springboot_demo
 * @description: msg and return data
 * @author: reuben
 * @create: 2020-03-19 13:14
 **/
@Data//get,set方法
@AllArgsConstructor//全参构造
@NoArgsConstructor//无参构造
@Component
public class MsgAndData implements Serializable {
    private String message;
    private String data;
}
