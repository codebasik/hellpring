package com.helljava.helpring.rowmapper;

import com.helljava.helpring.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by yongjunjung on 2016. 8. 25..
 */
public class UserRowMapper implements RowMapper<User>{

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User(rs.getString("ID"), rs.getString("PASSWORD"));
        return user;
    }
}
