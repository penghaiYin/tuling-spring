package com.yph.service;

import com.yph.pojo.Log;
public interface LogService {
    void save(Log log);

    void deductWithLog(Integer num, String fromName);
}
