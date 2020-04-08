package com.reuben.service;

import com.reuben.entity.PageParam;
import com.reuben.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author reuben
 * @program: springboot_demo
 **/
@Service
public interface UserService {


    /**
     * @Description: 添加User
     */
    String save(User user);

    /**
     * @Description: 查询所有
     */
    String getAll();

    /**
     * @Description: 通过id查询
     */
    String getByUserId(Integer id);

    /**
     * @Description: 通过id查找
     */
    String getByUserName(String name);

    /**
     * @Description: 逻辑删除
     */
    String deleteByUserId(Integer id);

    /**
     * @Description: Multiple delete批量删除
     */
    String multipleDeleteByUserId(List<Integer> ids);

    /**
     * @Description: update
     */
    String update(User user);

    /**
     * @Description: 分页条件查询
     */
    Page<User> getByPage(PageParam pageParam);
}
