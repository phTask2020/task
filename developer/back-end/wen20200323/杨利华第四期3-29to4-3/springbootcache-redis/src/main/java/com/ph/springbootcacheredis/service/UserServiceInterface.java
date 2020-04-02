package com.ph.springbootcacheredis.service;

import com.ph.springbootcacheredis.pojo.UserPOJO;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @description:
 * @author: 杨利华
 * @date: 2020/3/30
 */
public interface UserServiceInterface {


    public UserPOJO save(UserPOJO userPOJO);

    public UserPOJO userPOJOFindById(Integer id);

    public List<UserPOJO> userFindAll();

    public UserPOJO changeUserPOJO(UserPOJO userPOJO);

    public void deleteUserPOJO(int id);

    //用于存入redis list
    public List<UserPOJO> redisList();
    //用于存入redis set
    public Set<UserPOJO> redisSet();
}
