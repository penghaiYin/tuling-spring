package com.yph.service.impl;

import com.yph.dao.LogDao;
import com.yph.pojo.Log;
import com.yph.service.LogService;
import com.yph.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao logDao;

    @Autowired
    private StoreService storeService;

    @Override
    @Transactional
    public void save(Log log) {
        logDao.save(log);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deductWithLog(Integer num, String fromName){
        storeService.deduct(num, fromName);
        logDao.save(new Log("【"+fromName+"】"+"扣款【"+num+"】元", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
    }
}
