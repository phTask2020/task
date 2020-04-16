package com.reuben.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reuben.dao.UserDao;
import com.reuben.entity.PageParam;
import com.reuben.entity.User;
import com.reuben.entity.MsgAndData;
import com.reuben.service.UserService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @program: springboot_demo
 **/
@Component
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private MsgAndData msgAndData;
    //初始化Jackson的ObjectMapper
    private static ObjectMapper mapper = new ObjectMapper();

    /**
     * @Description: 添加User
     * @Param: [user]
     * @return: java.lang.String
     */
    @Override
    public String save(User user) {
        //判断数据是否为空
        //log.info(user.toString());
        if (isNull(user)) {
            return "No data received!";
        }
        //判断是否存在相同用户名
        if (!isExist(user.getUserName())) {
            user.setDel("0");//默认未删除
            userDao.save(user);
            return "save Success";
        } else return "Username already exists!";

    }

    /**
     * @Description: 获取所有User
     * @Param: []
     * @return: java.lang.String
     */
    @SneakyThrows
    @Override
    public String getAll() {
        List<User> all = userDao.findAll();
        String result=mapper.writeValueAsString(all);
        return result;

    }

    /**
     * @Description: 通过id查询
     * @Param: [id]
     * @return: java.lang.String
     */
    @SneakyThrows
    @Override
    public String getByUserId(Integer id) {
        Optional<User> byId = userDao.findById(id);
        // log.info(byId.toString());
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
    public String getByUserName(String name) {
        //String name_str = mapper.readValue(name, String.class);
        List<User> byUserName = userDao.findByUserName(name);
        String result = mapper.writeValueAsString(byUserName);
        return result;
    }

    /**
     * @Description:
     * @Param: [id]
     * @return: java.lang.String
     */
    @SneakyThrows
    @Override
    public String deleteByUserId(Integer id) {
        Optional<User> byId = userDao.findById(id);//通过id查询是否存在
        //log.info(String.valueOf(byId.isPresent()));

        //将返回结果封装到msgAndData
        if (!byId.isPresent()) {
            msgAndData.setMessage("User not exist!");
        } else {
            userDao.deleteByUserId(id);
            msgAndData.setMessage("delete Success!");
            byId.get().setDel("1");
            msgAndData.setData(byId.get().toString());

        }
        //json格式化
        String result = mapper.writeValueAsString(msgAndData);
        return result;

    }

    @SneakyThrows
    @Override

    /**
     * @Description: Multiple delete批量删除
     * @Param: [ids]
     * @return: java.lang.String
     */
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
    public String update(User user) {
        //log.info(user.toString());
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
        //log.info(pageParam.toString());
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
                    pr.add(criteriaBuilder.like(root.get("isdel").as(String.class), "%" + pageParam.getUser().getDel() + "%"));
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
        //log.info("isnull"+user.toString());
        if (null == user || 0 == user.getUserName().length()) {
            flag = true;
        }
        return flag;
    }
}
