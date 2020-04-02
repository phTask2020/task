package com.ph.springbootcacheredis.mapper;

import com.ph.springbootcacheredis.pojo.UserPOJO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @description:
 * @author: 杨利华
 * @date: 2020/3/30
 */
public interface UserMapper extends JpaRepository<UserPOJO,Integer> , JpaSpecificationExecutor<UserPOJO> {


}
