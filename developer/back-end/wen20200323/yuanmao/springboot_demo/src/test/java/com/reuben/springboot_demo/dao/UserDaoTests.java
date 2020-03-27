package com.reuben.springboot_demo.dao;

import com.reuben.dao.UserDao;
import com.reuben.entity.PageParam;
import com.reuben.entity.User;
import com.reuben.springboot_demo.SpringbootDemoApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Transactional
public class UserDaoTests extends SpringbootDemoApplicationTests {
    @Autowired
    private UserDao userDao;


    /**
     * @Description: 测试通过id查询用户
     */
    @Test
    public void testFindById() {
        Optional<User> byUserId = userDao.findById(1);
        System.out.println(byUserId.isPresent());
        Assert.assertTrue(true == byUserId.isPresent());
        //log.info(byUserId.toString());
    }

    /**
     * @Description: 测试通过userName查询用户
     */
    @Test
    public void testFindByuserName() {
        String ts_userName = "da";
        List<User> da = userDao.findByUserName(ts_userName);
        Assert.assertTrue(da.size() > 0);
        //log.info(da.toString());
    }

    /**
     * @Description: 测试添加用户
     */
    @Test
    public void testSave() {
        User ts_user = new User("test",
                "test",
                "test@mail.com");
        userDao.save(ts_user);
        Assert.assertTrue(ts_user.getUserId() > 0);
    }

    /**
     * @Description: 测试逻辑删除
     */
    @Test
    //@Rollback(false)
    public void testDeleteByuserId() {
        int ts_userId = 14;
        userDao.deleteByUserId(ts_userId);
        Optional<User> byId = userDao.findById(ts_userId);
        Assert.assertEquals("1", byId.get().getDel());
    }
    /**
     * @Description: 测试批量删除
     */
    @Test
    public void test_update() {
        int ts_userId = 14;
        String ts_userName = "test";
        String ts_userPassword = "test";
        String ts_email = "test@mail.cn";
        userDao.update(ts_userId, ts_userName, ts_userPassword, ts_email);
        Optional<User> byId = userDao.findById(ts_userId);
        Assert.assertEquals(ts_userName, byId.get().getUserName());
        Assert.assertEquals(ts_userPassword, byId.get().getUserPassword());
        Assert.assertEquals(ts_email, byId.get().getEmail());
    }
    /**
     * @Description: 测试分页查询
     */
    @Test
    public void test_findAll() {
        PageParam pageParam = new PageParam();
        pageParam.setPageSize(5);
        pageParam.setPageNum(0);
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
        Page<User> all = userDao.findAll(spec, pageable);
        Assert.assertTrue(all.getSize() > 0);

    }

}
