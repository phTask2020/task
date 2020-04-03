package com.reuben.dao;

import com.reuben.entity.User;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


/**
 * @author reuben
 */
public interface UserDao extends JpaRepository<User, Integer> {


    /**
     * @Description: 通过user_name查询
     * @Param: [name]
     * @return: java.util.List<com.reuben.pojo.User>
     */
    @Query(name = "findByUserName", nativeQuery = true, value = "select * from tb_user where user_name= :user_name")
    List<User> findByUserName(@Param("user_name") String name);

    /**
     * @Description: 逻辑删除
     * @Param: [userId]
     * @return: void
     */
    @Transactional
    @Modifying
    @Query(name = "deleteByUserId", nativeQuery = true, value = "update tb_user set isdel = '1' where id= :userId")
    void deleteByUserId(@Param("userId") Integer userId);

    /**
     * @Description: update
     * @Param: [id, user_name, user_password, email]
     * @return: void
     */
    @Transactional
    @Modifying
    @Query(name = "update", nativeQuery = true, value = "update tb_user set user_name = :user_name," +
            "user_password=:user_password,email=:email " +
            "where id=:id")
    void update(@Param("id") Integer id,
                @Param("user_name") String userName,
                @Param("user_password") String userPassword,
                @Param("email") String email);


    /**
    * @Description:  分页查询
    * @Param:  [spec,pageable]
    * @return:  Page<User>
    */
    Page<User> findAll(Specification<User> spec, Pageable pageable);
}
