package com.helljava.helpring.api;

import com.helljava.helpring.domain.Board;
import com.helljava.helpring.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by yongjunjung on 2016. 8. 23..
 */

@Controller
@RequestMapping(value = "/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @RequestMapping(value = "/list", method = GET)
    public String boardList(Model model) {

        List<Board> boardList = boardService.findAll();

        model.addAttribute("boardList", boardList);

        return "/board/list";
    }


}
