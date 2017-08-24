package com.lanou.service;

import com.lanou.bean.User;
import com.lanou.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by dllo on 17/8/23.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper mapper;

    public void insertUser(User user) {

        mapper.insertUser(user);
    }

    public User checkUser(User user) {

        User checkUser = mapper.checkUser(user);
        return checkUser;

    }


    public boolean checkUserName(String userName) {
        User user=new User();
        user.setName(userName);
        if(mapper.checkUserName(user)==0)
            return true;
        else
            return false;
    }

    public boolean regUser(User user) {

        if(mapper.checkUserName(user)==0){
            try{
                System.out.println(mapper.regUser(user));
                //System.out.println(user);
                return true;
            }
            catch(Exception e){
                e.printStackTrace();
                return false;
            }
        }
        else
            return false;
    }
}
