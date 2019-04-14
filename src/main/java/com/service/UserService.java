package com.service;

import com.pojo.User;

import java.util.List;

/**
 * com.service
 * Created by ForMe
 * 2019/3/27
 * 12:40
 */
public interface UserService {
    List<User> getAllUser();
    void addUser(User user);
    User checkUsername(String username);
    User checkEmail(String email);
    void updatemessage(User user);
    int searchId(String username);
}
