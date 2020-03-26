package cn.ph.springboot01.userService;

import cn.ph.springboot01.userBean.Student;

import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author 22356
 * @Date 2020/3/19 15:39
 */
public interface UserService {
//根据ID查询
    public Student queryById(Integer id);
//查询全部
    public List<Student> queryAll();
//添加person
    public void add(Student student);
//根据ID删除
    public void deleteById(Integer id);
//修改
    public void updata(Student student);
}
