package com.hxy.mongo.controller;

import com.hxy.mongo.bean.UserData;
import com.hxy.mongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/save")
    public String save(UserData user) {
        userService.saveUser(user);
        return "Save Successfully";
    }

    @RequestMapping("/find")
    public List<UserData> find() {
        return userService.findAll();
    }

    @RequestMapping("/delete")
    public String delete(Integer id) {
        userService.deleteById(id);
        return "Delete Successfully";
    }

}
