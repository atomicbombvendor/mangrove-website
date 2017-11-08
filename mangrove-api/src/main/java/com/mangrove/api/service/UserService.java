package com.mangrove.api.service;

import com.mangrove.api.model.User;
import com.mangrove.api.model.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by ZZ on 2017/6/27.
 */

/**
 * Table For Blog Users Table
 */
@Service
public class UserService {
    Logger log = Logger.getLogger(UserService.class);

    @Resource
    private UserRepository usersDao;


    public User getUser(String userName, String userPsd){
        User user = usersDao.findUser(userName, userPsd);
        if(user == null){
            log.info("Can't find user: "+userName);
            return null;
        }
        return user;
    }
}
