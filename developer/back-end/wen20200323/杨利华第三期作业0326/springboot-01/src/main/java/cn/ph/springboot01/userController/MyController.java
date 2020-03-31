package cn.ph.springboot01.userController;

import cn.ph.springboot01.userBean.Student;
import cn.ph.springboot01.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @Description: 练习
 * @Author 22356
 * @Date 2020/3/18 13:12
 */

@Controller
public class MyController {
    @Autowired
    UserService service;

    //尝试把数据返回页面
    @GetMapping("/studentTable")
    public String list(Model model) {
        Collection<Student> students = service.queryAll();
        model.addAttribute("students", students);
        return "list";
    }

    //来到员工添加页面
    @GetMapping("/add")
    public String add() {
        return "Add";
    }

    //添加员工
    @PostMapping("/addStudent")
    public String addStudent(Student student) {
        service.add(student);
        //redirect:重定向到一个地址 /代表当前目录
        //forward：转发到一个地址
        return "redirect:/studentTable";
    }

    //来到修改页面
    @GetMapping("/change/{id}")
    public String change(@PathVariable("id") Integer id, Model model) {
        //由ID查出学生
        Student student = service.queryById(id);
        //用于修改回显
        model.addAttribute("student", student);

        //修改添加二合一页面
        return "Add";
    }

    //修改员工
    @PutMapping("/addStudent")
    public String changeStudent(Student student) {

        service.updata(student);
        return "redirect:/studentTable";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        service.deleteById(id);
        return "redirect:/studentTable";
    }
}
