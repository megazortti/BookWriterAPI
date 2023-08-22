package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.entity.User;
import com.api.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userSerivce){
        this.userService = userSerivce;
    }
    @PostMapping()
    public User addUser(User user){
        // return user;
        return userService.saveUser(user);
    }
    @GetMapping()
    public List<User> getUsers(){
        return userService.getUsers();
    }
    
    
}
