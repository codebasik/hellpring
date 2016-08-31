package com.helljava.helpring.repository;

import com.helljava.helpring.domain.User;
import com.helljava.helpring.rowmapper.UserRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by yongjunjung on 2016. 8. 23..
 */
public class LoginRepositoryImpl extends JdbcDaoSupport implements LoginRespository {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    public LoginRepositoryImpl(DataSource dataSource) {
        super.setDataSource(dataSource);
    }

    public User findByUserIdAndPassword(String id, String password) {

        List<User> user = getJdbcTemplate().query(
                "SELECT * FROM USER WHERE ID=? AND PASSWORD=?",
                new UserRowMapper(),
                id, password);
        
        return user.isEmpty() ? null : user.get(0);
    }
}
