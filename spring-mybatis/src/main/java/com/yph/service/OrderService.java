package com.yph.service;


import org.springframework.beans.factory.annotation.Autowired;

public class OrderService {
    private MemberService memberService;

    @Autowired
    public OrderService(MemberService memberService) {
        System.out.println("构造order...");
        this.memberService = memberService;
    }
}
