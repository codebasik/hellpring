package com.helljava.helpring.rowmapper;

import com.helljava.helpring.domain.Board;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by yongjunjung on 2016. 8. 29..
 */
public class BoardRowMapper implements RowMapper<Board> {

    @Override
    public Board mapRow(ResultSet rs, int rowNum) throws SQLException {

        Board board = new Board(Integer.parseInt(rs.getString("BOARD_SEQ")), rs.getString("TITLE"), rs.getString("CONTENT"), rs.getString("NAME"));

        return board;
    }
}
