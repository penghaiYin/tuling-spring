package com.yph.dao.impl;

import com.yph.dao.LogDao;
import com.yph.pojo.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LogDaoImpl implements LogDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void save(Log log) {
        jdbcTemplate.update("insert into log(detail, date) values('"
                +log.getDetail()+"','"+log.getDate()+"')");
    }
}
