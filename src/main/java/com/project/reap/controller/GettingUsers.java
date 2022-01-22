package com.project.reap.controller;

import com.project.reap.Entity.User;
import com.project.reap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GettingUsers {

    @Autowired
    UserService userService;

    @PostMapping("/getAllUsers")
    public List<User> getAllUsers(){

        List<User> userList= userService.findAll();
        return userList;
    }


}
