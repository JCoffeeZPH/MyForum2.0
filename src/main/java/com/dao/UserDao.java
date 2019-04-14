package com.dao;

import com.pojo.User;
import java.util.List;

/**
 * com.dao
 * Created by ForMe
 * 2019/3/27
 * 12:19
 */
public interface UserDao {
    List<User> getAllUser();
    void addUser(User user);
    User checkUsername(String username);
    User checkEmail(String email);
    void updatemessage(User user);
    int searchId(String username);
//    User getUserByName(String username);
}
