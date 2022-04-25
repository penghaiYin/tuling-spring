package com.yph.controller;

import com.yph.pojo.Log;
import com.yph.service.impl.StoreTransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class StoreTransactionController {

    @Autowired
    private StoreTransactionServiceImpl storeTransactionService;

    public void transfer(Integer num, String fromName, String receiveName){
        storeTransactionService.transfer(num, fromName, receiveName);
    }

    public void transferSupports(Integer num, String fromName, String receiveName){
        storeTransactionService.transferSupports(num, fromName, receiveName);
    }

    public void transferSupportsWithLog(Integer num, String fromName, String receiveName){
        storeTransactionService.transferSupportsWithLog(num, fromName, receiveName,new Log("【"+fromName+"】"+"转给【"+receiveName+"】【"+num+"】元"
                , new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
    }

    public void transferRequireNew(Integer num, String fromName, String receiveName){
        storeTransactionService.transferRequireNew(num, fromName, receiveName);
    }

}
