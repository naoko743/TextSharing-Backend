package com.freshersClass.textSharing.controller;

import java.io.IOException;
import java.util.TreeMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.freshersClass.textSharing.entity.User;
import com.freshersClass.textSharing.service.UserService;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public User login(@RequestBody TreeMap<String, String> credentials, HttpServletResponse response) throws
            IOException{
        User user = userService.login(credentials.get("username"), credentials.get("password"));
        if(user != null)
            return  user;
        response.sendError(HttpStatus.UNAUTHORIZED.value());
        return null;
    }

}


