package com.helljava.helpring.service;

import com.helljava.helpring.domain.Board;
import com.helljava.helpring.repository.BoardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by yongjunjung on 2016. 8. 29..
 */
public class BoardService {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    BoardRepository boardRepository;

    public List<Board> findAll() {

        List<Board> boardList = boardRepository.findAll();

        log.info("[BoardService] findAll >> {}", boardList.toString());

        return boardList;
    }
}
