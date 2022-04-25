package com.yph.service;

import com.yph.pojo.Log;

public interface StoreTransactionService {

    void deduct(Integer num, String name);

    void add(Integer num, String name);

    void addException(Integer num, String name);

    void transfer(Integer num, String fromName, String receiveName);

    void transferSupports(Integer num, String fromName, String receiveName);

    void transferSupportsWithLog(Integer num, String fromName, String receiveName, Log log);

    void deduct2(Integer num, String name);

    void transferRequireNew(Integer num, String fromName, String receiveName);

}
