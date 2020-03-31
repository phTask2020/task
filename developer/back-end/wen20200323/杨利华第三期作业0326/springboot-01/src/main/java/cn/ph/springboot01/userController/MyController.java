package cn.ph.springboot01.userController;

import cn.ph.springboot01.userBean.Student;
import cn.ph.springboot01.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * @Description: 练习
 * @Author 22356
 * @Date 2020/3/18 13:12
 */

@RestController
public class MyController {
    @Autowired
    UserService service;

    //尝试把数据返回页面
    @RequestMapping("/hello")
    public String list(Model model){
        Collection<Student> students=service.queryAll();
        model.addAttribute("students",students);
        return "list";
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") Integer id){

        return service.queryById(id);
    }

    @GetMapping("/findAll")
    public List<Student> findAll(){
        return service.queryAll();
    }

    @PostMapping("/add")
    public Student add(Student student){
        System.out.println(student);
        service.add(student);
        return student;
    }

    @PutMapping("/updata")
    public String updata(@RequestBody Student student){
        service.updata(student);
        System.out.println(student.getId());

        return "ID为："+ student.getId()+"  的用户成功修改为   >>>"+ student.getName()+"=="+ student.getGender();
    }

    @DeleteMapping("/deleteById")
    public String delete(@PathVariable("id") Integer id){
        Student student =findById(id);
        service.deleteById(id);
        return student.getName()+"=="+ student.getGender()+"   >>>   "+"删除成功";
    }
}
