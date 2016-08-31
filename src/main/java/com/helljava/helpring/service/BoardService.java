package com.helljava.helpring.service;

import com.helljava.helpring.domain.Board;
import com.helljava.helpring.domain.BoardDto;
import com.helljava.helpring.repository.BoardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yongjunjung on 2016. 8. 29..
 */
public class BoardService {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    BoardRepository boardRepository;

    public List<Board> list(String searchWord, String queryInput) {

        List<Board> boardList = new ArrayList<>();

        if (StringUtils.isEmpty(queryInput)) {
            queryInput = "all";
        }

        switch (queryInput) {
            case "NAME":
                log.info("[boardrepository] findByName >>");
                boardList = boardRepository.findByName(searchWord);
                break;
            case "CONTENT":
                log.info("[boardrepository] findByContent >>");
                boardList = boardRepository.findByContent(searchWord);
                break;
            case "TITLE":
                log.info("[boardrepository] findByTitle >>");
                boardList = boardRepository.findByTitle(searchWord);
                break;
            default:
                log.info("[boardrepository] findAll >>");
                boardList = boardRepository.findAll();
                break;
        }

        return boardList;
    }

    public Board detail(String seq) {
        return boardRepository.boardDetail(seq);
    }

    public void delete(String seq) {
        boardRepository.delete(seq);
    }

    public void write(BoardDto boardDto) {
        boardRepository.write(boardDto);
    }


}
