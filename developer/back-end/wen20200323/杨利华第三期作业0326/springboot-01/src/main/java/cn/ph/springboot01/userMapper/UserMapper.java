package cn.ph.springboot01.userMapper;

import cn.ph.springboot01.userBean.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author 22356
 * @Date 2020/3/19 15:40
 */
public interface UserMapper extends JpaRepository<Student, Integer>, JpaSpecificationExecutor<Student> {


}
