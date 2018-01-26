package com.freshersClass.textSharing.controller;

import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.freshersClass.textSharing.service.UserService;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public boolean login(@RequestBody TreeMap<String, String> credentials) {
        System.out.println("Username: " + credentials);
       // userService.getUserByUsername(username);
        return true;
    }

}


