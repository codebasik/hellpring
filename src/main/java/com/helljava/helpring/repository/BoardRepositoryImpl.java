package com.helljava.helpring.repository;

import com.helljava.helpring.domain.Board;
import com.helljava.helpring.rowmapper.BoardRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by yongjunjung on 2016. 8. 29..
 */
public class BoardRepositoryImpl extends JdbcDaoSupport implements BoardRepository {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    public BoardRepositoryImpl(DataSource dataSource) {
        super.setDataSource(dataSource);
    }

    @Override
    public List<Board> findAll() {

        List<Board> boardList = getJdbcTemplate().query(
                "SELECT * FROM BOARD",
                new BoardRowMapper());

        return boardList.isEmpty() ? null : boardList;
    }
}
