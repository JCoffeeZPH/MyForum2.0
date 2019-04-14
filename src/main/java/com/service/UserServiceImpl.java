package com.service;

import com.dao.UserDao;
import com.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * com.service
 * Created by ForMe
 * 2019/3/27
 * 12:41
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Resource
    private UserDao userDao;

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public User checkUsername(String username) {
        return userDao.checkUsername(username);
    }

    @Override
    public User checkEmail(String email) {
        return userDao.checkEmail(email);
    }

    @Override
    public void updatemessage(User user) {
        userDao.updatemessage(user);
    }

    @Override
    public int searchId(String username) {
        return userDao.searchId(username);
    }
}
