package com.simplerequest.test01.userdemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface UserDao extends JpaRepository<User,Integer> {
}
