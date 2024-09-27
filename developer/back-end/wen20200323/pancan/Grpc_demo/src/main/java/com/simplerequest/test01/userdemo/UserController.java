package com.simplerequest.test01.userdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/userAdd",method = RequestMethod.PUT)
    public User addUser(@RequestParam User user){
        User user1 = userService.add(user);
        return user1;
    }

    @RequestMapping(value = "/userUpdate",method = RequestMethod.POST)
    public void insertUser(@RequestParam User user){
        userService.update(user);
    }

    @RequestMapping(value = "/userDeleteById/{id}",method = RequestMethod.DELETE)
    public void deleteUserById(@PathVariable("id") int id){
        userService.delete(id);
    }

    @RequestMapping(value = "/userFindById/{id}",method = RequestMethod.GET)
    public User findUserById(@PathVariable int id){
        User user = userService.findById(id);
        return user;
    }
}
