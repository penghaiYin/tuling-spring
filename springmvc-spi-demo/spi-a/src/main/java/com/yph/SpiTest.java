package com.yph;

import com.yph.service.IUserService;

import java.util.ServiceLoader;

public class SpiTest {
    public static void main(String[] args) {
        ServiceLoader<IUserService> userServices = ServiceLoader.load(IUserService.class);
        for (IUserService userService : userServices) {
            userService.test();
        }
    }
}
