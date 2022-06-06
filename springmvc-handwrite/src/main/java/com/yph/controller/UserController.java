package com.yph.controller;

import com.yph.bean.User;
import com.yph.service.UserService;
import com.springmvc.annotation.YphAutoWired;
import com.springmvc.annotation.YphController;
import com.springmvc.annotation.YphRequestMapping;
import com.springmvc.annotation.YphResponseBody;

/**
 * @author 白起老师
 */
@YphController
public class UserController {

       @YphAutoWired(value="userService")
       private UserService userService;


       //定义方法
       @YphRequestMapping("/findUser")
       public  String  findUser(String name){
           //调用服务层
           userService.findUser();
           return "forward:/success.jsp";
       }

    @YphRequestMapping("/getData")
    @YphResponseBody  //返回json格式的数据
    public User getData(){
        //调用服务层
        return userService.getUser();
    }
}
