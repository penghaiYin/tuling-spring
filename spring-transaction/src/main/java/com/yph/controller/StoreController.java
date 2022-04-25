package com.yph.controller;

import com.yph.pojo.Store;
import com.yph.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class StoreController {

    @Autowired
    private StoreService storeService;

    public void getBalance(String name){
        int balance = storeService.getBalance(name);
        System.out.println("【"+name+"】余额是"+balance);
    }

    public void getBalanceRepeatable(String name) throws InterruptedException {
        storeService.getBalanceRepeatable(name);
    }

    public void deduct(Integer num, String name){
        storeService.deduct(num, name);
        System.out.println("deduct执行结束【"+ name +"】余额减【"+num+"】");
    }

    public void delayDeduct(Integer num, String name) throws InterruptedException {
        storeService.delayDeduct(num, name);
        System.out.println("delayDeduct执行结束【"+ name +"】余额减【"+num+"】");
    }

    public void countRecord(String tableName) throws InterruptedException {
        int record = storeService.countRecord(tableName);
        System.out.println("【"+tableName+"】"+"表共有"+record+"条数据");
    }

    public void insert(Store store) {
        storeService.insert(store);
        System.out.println("store表插入一条数据");
    }


}
