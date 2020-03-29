package cn.ph.springboot01.userService.serviceImpl;

import cn.ph.springboot01.userBean.Student;
import cn.ph.springboot01.userMapper.UserMapper;
import cn.ph.springboot01.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author 22356
 * @Date 2020/3/19 15:39
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public Student queryById(Integer id) {
        //根据ID查询
        return mapper.findOne(id);
    }

    @Override
    public List<Student> queryAll() {
        //查询全部
        return mapper.findAll();
    }

    @Override
    public void add(Student student) {
        //添加
        mapper.save(student);
    }

    @Override
    public void deleteById(Integer id) {
        //根据ID查询
        mapper.delete(id);
    }

    @Override
    public void updata(Student student) {
        //修改
        mapper.saveAndFlush(student);
    }
}
