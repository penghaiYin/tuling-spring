package com.yph.service.impl;

import com.yph.dao.StoreDao;
import com.yph.pojo.Store;
import com.yph.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * 可以标记在类上面（当前类所有的方法都运用上了事务）
 * 如果类和方法都存在@Transactional会以方法的为准
 */
@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreDao storeDao;

    @Override
    public int getBalance(String name) {
        return storeDao.getBalance(name);
    }

//    @Transactional
    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public int getBalanceRepeatable(String name) throws InterruptedException {
        int balance = storeDao.getBalanceRepeatable(name);
        System.out.println("第一次："+balance);
        Thread.sleep(10000);

        int balance2 = storeDao.getBalanceRepeatable(name);
        System.out.println("第二次："+balance2);
        Thread.sleep(10000);

        int balance3 = storeDao.getBalanceRepeatable(name);
        System.out.println("第三次："+balance3);
        return balance;
    }

    @Override
    @Transactional
    public void delayDeduct(Integer num, String name) throws InterruptedException {
            storeDao.deduct(num, name);
            Thread.sleep(10000);
    }

    @Override
    @Transactional
    public void deduct(Integer num, String name) {
        storeDao.deduct(num, name);
    }


    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public int countRecord(String tableName) throws InterruptedException {
        int record = storeDao.countRecord(tableName);
        System.out.println("第一次："+record);
        Thread.sleep(10000);

        int record2 = storeDao.countRecord(tableName);
        System.out.println("第二次："+record2);
        Thread.sleep(10000);

        int record3 = storeDao.countRecord(tableName);
        System.out.println("第三次："+record3);
        return record;
    }

    @Override
    public void insert(Store store) {
        storeDao.insert(store);
    }

}
