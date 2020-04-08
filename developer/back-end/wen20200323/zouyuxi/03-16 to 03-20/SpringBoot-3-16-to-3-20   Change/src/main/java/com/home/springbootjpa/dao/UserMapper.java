package com.home.springbootjpa.dao;

import com.home.springbootjpa.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: 邹玉玺
 * @date: 2020/3/18-22:16
 */
//继承接口

public interface UserMapper extends JpaRepository<User,Integer> {//后者是传入该表的主键

}
