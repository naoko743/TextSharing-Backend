package com.freshersClass.textSharing.controller;

import java.util.TreeMap;

import javax.ws.rs.FormParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.freshersClass.textSharing.service.FileService;

@RestController
@RequestMapping("/textSharing")
public class TextSharingController {

    @Autowired FileService fileService;

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public boolean login( @RequestBody TreeMap<String, String> credentials){
        //fileService.createFile( File file);
        System.out.println("Username: " + credentials);
        return true;
    }


}
