package com.yph.service;

import com.yph.pojo.Store;

public interface StoreService {

    int getBalance(String name);

    int getBalanceRepeatable(String name) throws InterruptedException;

    void deduct(Integer num, String name);

    void delayDeduct(Integer num, String name) throws InterruptedException;

    int countRecord(String tableName) throws InterruptedException;

    void insert(Store store);
}
