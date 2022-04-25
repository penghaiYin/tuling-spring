package com.yph.service.impl;

import com.yph.dao.StoreDao;
import com.yph.pojo.Log;
import com.yph.service.LogService;
import com.yph.service.StoreTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 可以标记在类上面（当前类所有的方法都运用上了事务）
 * 如果类和方法都存在@Transactional会以方法的为准
 */
@Service
public class StoreTransactionServiceImpl implements StoreTransactionService {

    @Autowired
    private StoreDao storeDao;

    @Autowired
    private LogService logService;

    @Override
    public void deduct(Integer num, String name) {
        storeDao.deduct(num, name);
    }

    @Override
    public void add(Integer num, String name) {
        storeDao.add(num, name);
    }

    @Override
    public void addException(Integer num, String name) {
        int i=10/0;
        storeDao.add(num, name);
    }

    @Override
    @Transactional
    public void transfer(Integer num, String fromName, String receiveName) {
        deduct(num, fromName);
        add(num, receiveName);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void transferSupports(Integer num, String fromName, String receiveName) {
        deduct(num, fromName);
        addException(num, receiveName);
    }

    @Override
    @Transactional
    public void transferSupportsWithLog(Integer num, String fromName, String receiveName, Log log) {
        transferSupports(num, fromName, receiveName);
        saveLog(log);
    }

    public void saveLog(Log log){
        logService.save(log);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deduct2(Integer num, String name) {
        storeDao.deduct(num, name);
    }

    @Override
    @Transactional
    public void transferRequireNew(Integer num, String fromName, String receiveName) {
//        logService.deductWithLog(num, fromName);
        deduct2(num, fromName);
        addException(num, receiveName);
        logService.save(new Log("【"+receiveName+"】"+"增加【"+num+"】元"
                , new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
    }




}
