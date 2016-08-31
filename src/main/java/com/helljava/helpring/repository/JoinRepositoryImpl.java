package com.helljava.helpring.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;

/**
 * Created by yongjunjung on 2016. 7. 21..
 */
public class JoinRepositoryImpl extends JdbcDaoSupport implements JoinRepository{

    @Autowired
    public JoinRepositoryImpl(DataSource dataSource) {
        super.setDataSource(dataSource);
    }

    @Override
    public void save(String id, String name, String password, String email) {
        getJdbcTemplate().update("INSERT INTO USER (ID, NAME, PASSWORD, EMAIL) VALUES (?,?,?,?)",
                id, name, password, email);

    }
}
