package com.freshersClass.textSharing.controller;

import java.util.List;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.freshersClass.textSharing.entity.User;
import com.freshersClass.textSharing.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public void create(@RequestBody User user) {
        System.out.println("Name: " + user.getName() + " Username: " + user.getUsername() + "Password: " + user.getPassword());
        userService.saveUser(user);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/findAll")
    public List<User> findAll() {
        List<User> userList = userService.getAllUser();
        return userService.getAllUser();
    }

}
