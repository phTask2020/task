package com.reuben.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reuben.dao.UserDao;
import com.reuben.entity.PageParam;
import com.reuben.entity.User;
import com.reuben.entity.MsgAndData;
import com.reuben.service.UserService;
import com.reuben.util.annotation.cache.CacheRemove;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author reuben
 * @program: springboot_demo
 **/
@Component
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private MsgAndData msgAndData;
    /**
     * 初始化Jackson的ObjectMapper
     */
    private static ObjectMapper mapper = new ObjectMapper();

    /**
     * @Description: 添加User
     * @Param: [user]
     * @return: java.lang.String
     */
    @Override
    @CachePut(value = "user", key = "'user'.concat(#user.userName.toString())")
    public String save(User user) {
        /**判断数据是否为空*/
        if (isNull(user)) {
            return "No data received!";
        }
        /**判断是否存在相同用户名*/
        if (!isExist(user.getUserName())) {
            /**默认未删除*/
            user.setDel("0");
            userDao.save(user);
            String byUserName = this.getByUserName(user.getUserName());
/**           return "save Success";*/
            return byUserName;
        } else {
            return "Username already exists!";
        }

    }

    /**
     * @Description: 获取所有User
     * @Param: []
     * @return: java.lang.String
     */
    @SneakyThrows
    @Override
    @CachePut(value = "user", key = "'user'.concat(new String('all'))")
    public String getAll() {
        List<User> all = userDao.findAll();
        String result = mapper.writeValueAsString(all);
        return result;

    }

    /**
     * @Description: 通过id查询
     * @Param: [id]
     * @return: java.lang.String
     */
    @SneakyThrows
    @Override
    @Cacheable(value = "user", key = "'user'.concat(#id.toString())")
    public String getByUserId(Integer id) {
        Optional<User> byId = userDao.findById(id);
        String result = mapper.writeValueAsString(byId.get());
        return result;
    }

    /**
     * @Description: 通过userName查询
     * @Param: [name]
     * @return: java.lang.String
     */
    @SneakyThrows
    @Override
    @Cacheable(value = "user", key = "'user'.concat(#name.toString())")
    public String getByUserName(String name) {
        List<User> byUserName = userDao.findByUserName(name);
        String result = mapper.writeValueAsString(byUserName);
        return result;
    }

    /**
     * @Description:deleteByUserId
     * @Param: [id]
     * @return: java.lang.String
     */
    @SneakyThrows
    @Override
    @CacheEvict(value = "user", key = "'user'.concat(#id.toString())", beforeInvocation = true)
    public String deleteByUserId(Integer id) {
        /**通过id查询是否存在*/
        Optional<User> byId = userDao.findById(id);

        if (!byId.isPresent()) {
            msgAndData.setMessage("User not exist!");
        } else {
            userDao.deleteByUserId(id);
            msgAndData.setMessage("delete Success!");
            byId.get().setDel("1");
            msgAndData.setData(byId.get().toString());

        }
        /**json格式化*/
        String result = mapper.writeValueAsString(msgAndData);
        return result;

    }


    /**
     * @Description: Multiple delete批量删除
     * @Param: [ids]
     * @return: java.lang.String
     */
    @SneakyThrows
    @Override
    @CacheRemove({"user::*"})
    public String multipleDeleteByUserId(List<Integer> ids) {
        List<String> results = new ArrayList<>();
        results.add("result");
        if (0 != ids.size()) {
            for (Integer id : ids) {
                results.add(this.deleteByUserId(id));
            }
        }

        String result = mapper.writeValueAsString(results);
        return result;
    }

    /**
     * @Description: update
     * @Param: [user]
     * @return: java.lang.String
     */
    @SneakyThrows
    @Override
    @CachePut(value = "user", key = "'user'.concat(#user.userId.toString())")
    public String update(User user) {
        if (isNull(user)) {
            return "No data received!";
        }
        if (isExist(user.getUserName())) {
            msgAndData.setMessage("Update failed!: userName already exists!");
        } else {
            userDao.update(user.getUserId(),
                    user.getUserName(),
                    user.getUserPassword(),
                    user.getEmail());

            msgAndData.setMessage("update Success!");
            msgAndData.setData(userDao.findById(user.getUserId()).get().toString());
        }
        String result = mapper.writeValueAsString(msgAndData);
        return result;
    }

    /**
     * @Description: 分页条件查询
     * @Param: [pageParam]
     * @return: org.springframework.data.domain.Page<com.reuben.entity.User>
     */
    @Override
    public Page<User> getByPage(PageParam pageParam) {
        if (pageParam.getPageNum() == null) {
            pageParam.setPageNum(0);
        }
        if (null == pageParam.getPageSize() || 0 == pageParam.getPageSize()) {
            pageParam.setPageSize(5);
        }

        Pageable pageable = PageRequest.of(pageParam.getPageNum(), pageParam.getPageSize(), Sort.by(Sort.Direction.ASC, "userId"));

        Specification<User> spec = (Specification<User>) (root, criteriaQuery, criteriaBuilder) -> {
            ArrayList<Object> pr = new ArrayList<>();
            if (pageParam.getUser() != null) {
                if (pageParam.getUser().getUserName() != null) {
                    pr.add(criteriaBuilder.like(root.get("userName").as(String.class), "%" + pageParam.getUser().getUserName() + "%"));
                }
                if (pageParam.getUser().getUserPassword() != null) {
                    pr.add(criteriaBuilder.like(root.get("userPassword").as(String.class), "%" + pageParam.getUser().getUserPassword() + "%"));
                }
                if (pageParam.getUser().getEmail() != null) {
                    pr.add(criteriaBuilder.like(root.get("email").as(String.class), "%" + pageParam.getUser().getEmail() + "%"));
                }
                if (pageParam.getUser().getDel() != null) {
                    pr.add(criteriaBuilder.like(root.get("del").as(String.class), "%" + pageParam.getUser().getDel() + "%"));
                }
            }
            return criteriaBuilder.and(pr.toArray(new Predicate[pr.size()]));

        };
        return userDao.findAll(spec, pageable);
    }

    /**
     * @Description: 判断用户名是否存在
     * @Param: [userName]
     * @return: Boolean
     */
    private Boolean isExist(String userName) {
        boolean flag = false;
        List<User> byUserName = userDao.findByUserName(userName);
        if (byUserName.size() > 0) {
            flag = true;
        }
        return flag;
    }

    /**
     * @Description: 判断数据是否为空
     * @Param: [user]
     * @return: Boolean
     */
    private Boolean isNull(User user) {
        boolean flag = false;
        if (null == user || 0 == user.getUserName().length()) {
            flag = true;
        }
        return flag;
    }
}
