package com.yph.dao;

import com.yph.pojo.Store;

public interface StoreDao {

    int getBalance(String name);

    int getBalanceRepeatable(String name);

    void deduct(Integer num, String name);

    void add(Integer num, String name);

    int countRecord(String tableName);

    void insert(Store store);
}
