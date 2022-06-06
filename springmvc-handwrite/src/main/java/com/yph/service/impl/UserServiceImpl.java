package com.yph.service.impl;

import com.yph.bean.User;
import com.yph.service.UserService;
import com.springmvc.annotation.YphService;

/**
 * @author 白起老师
 */
@YphService(value="userService")
public class UserServiceImpl implements UserService {


    public  void  findUser(){
        System.out.println("====调用UserServiceImpl==findUser===");
    }

    public User getUser(){

       return new User(1,"老王","admin");
    }

}
