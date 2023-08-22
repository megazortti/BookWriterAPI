package com.api.service;

import java.util.List;

import com.api.entity.User;

public interface UserService {
    User saveUser(User user);
    List<User> getUsers();
    User findByMail(String mail);
}
