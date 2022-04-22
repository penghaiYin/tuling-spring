package com.yph.service;

import com.yph.mapper.MemberMapper;
import com.yph.mapper.OrderMapper;
import com.yph.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private MemberMapper memberMapper;

    public void test(){
        System.out.println(userMapper.selectByUserId());
        System.out.println(orderMapper.selectByOrderId());
        System.out.println(memberMapper.selectByMemberId());
    }

}
