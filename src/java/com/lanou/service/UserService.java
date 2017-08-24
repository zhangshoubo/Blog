package com.lanou.service;

import com.lanou.bean.User;

/**
 * Created by dllo on 17/8/23.
 */
public interface UserService{
    void insertUser(User user);

    User checkUser(User user);

    boolean checkUserName(String userName);

    boolean regUser(User user);
}
