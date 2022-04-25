package com.yph.dao.impl;

import com.yph.dao.StoreDao;
import com.yph.pojo.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StoreDaoImpl implements StoreDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int getBalance(String name) {
        Integer balance = jdbcTemplate.queryForObject("select balance from store where name='" + name + "'", Integer.class);
        return balance;
    }

    @Override
    public int getBalanceRepeatable(String name) {
        Integer balance = jdbcTemplate.queryForObject("select balance from store where name='" + name + "'", Integer.class);
        return balance;
    }

    @Override
    public void deduct(Integer num, String name) {
        jdbcTemplate.update("update store set balance=balance-"+num +" where name='"+name+"'");
    }

    @Override
    public void add(Integer num, String name) {
        jdbcTemplate.update("update store set balance=balance+"+num +" where name='"+name+"'");
    }

    @Override
    public int countRecord(String tableName) {
        return jdbcTemplate.queryForObject("select count(0) from "+tableName,Integer.class);
    }

    @Override
    public void insert(Store store) {
        jdbcTemplate.update("insert into store(name,balance) values('"+store.getName()+"',"+store.getBalance()+")");
    }
}
