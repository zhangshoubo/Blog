package com.lanou.mapper;

import com.lanou.bean.User;
import org.springframework.stereotype.Repository;

/**
 * Created by dllo on 17/8/23.
 */
@Repository
public interface UserMapper {
    void  insertUser(User user);
    void checkUser(User user);

    int checkUserName(User user);

    boolean regUser(User user);
}
