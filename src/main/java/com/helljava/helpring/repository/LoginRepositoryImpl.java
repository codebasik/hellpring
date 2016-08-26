package com.helljava.helpring.repository;

import com.helljava.helpring.domain.User;
import com.helljava.helpring.rowmapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by yongjunjung on 2016. 8. 23..
 */
public class LoginRepositoryImpl extends JdbcDaoSupport implements LoginRespository {

    @Autowired
    public LoginRepositoryImpl(DataSource dataSource) {
        super.setDataSource(dataSource);
    }

    public User findByUserIdAndPassword(String id) {

        List<User> user = getJdbcTemplate().query(
                "SELECT * FROM USER WHERE ID=?",
                new UserRowMapper(),
                id);

        return user.isEmpty() ? null : user.get(0);
    }
}
