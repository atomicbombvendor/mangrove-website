package com.mangrove.api.controller;

import com.mangrove.api.dao.UserDao;
import com.mangrove.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jack on 2017/11/3.
 */
@RestController
@RequestMapping("/hello")
public class UserController {

    @Autowired
    UserDao userDao;

    @RequestMapping("/get-by-name")
    @ResponseBody
    public String getByName(String name) {
        String userId;
        User user = userDao.findByUserName("admin");
        if (user != null) {
            userId = String.valueOf(user.getUserId());
            User user1 = new User();
            user1.setUserName("JustDoIt");
            user1.setPassword("12345678");
            user1.setCredits(5);
            user1.setLastIp("11111111");
            user1.setLastVisit(null);
            userDao.save(user1);
            return "The user id is: " + userId;
        }
        return "user " + name + " is not exist.";
    }
}
