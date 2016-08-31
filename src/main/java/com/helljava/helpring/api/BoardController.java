package com.helljava.helpring.api;

import com.helljava.helpring.domain.Board;
import com.helljava.helpring.domain.BoardDto;
import com.helljava.helpring.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by yongjunjung on 2016. 8. 23..
 */

@Controller
@RequestMapping(value = "/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @RequestMapping(value = "/list", method = GET)
    public String boardList(Model model,
                            @RequestParam(value = "searchWord", required = false) String searchWord,
                            @RequestParam(value = "queryInput", required = false) String queryInput) {

        Map<String, String> boardSearch = new HashMap<>();
        boardSearch.put("searchWord", searchWord);
        boardSearch.put("queryInput", queryInput);

        List<Board> boardList = boardService.list(searchWord, queryInput);

        model.addAttribute("boardList", boardList);
        model.addAttribute("boardSearch", boardSearch);

        return "/board/list";
    }

    @RequestMapping(value = "/detail", method = GET)
    public String boardDetail(Model model,
                              @RequestParam(value = "seq", required = true) String seq) {

        Board detail = boardService.detail(seq);

        model.addAttribute("detail", detail);

        return "/board/detail";
    }

    @RequestMapping(value = "/delete", method = GET)
    public String boardDelete(Model model,
                              @RequestParam(value = "seq", required = true) String seq) {

        boardService.delete(seq);

        return "redirect:/board/list";
    }

    @RequestMapping(value = "/write", method = GET)
    public String boardWrite(Model model) {
        return "/board/write";
    }

    //TODO @RequestParam -> @RequestBody
    @RequestMapping(value = "/write", method = POST)
    public String boardWrite(Model model,
                             @RequestParam(value = "username", required = true) String username,
                             @RequestParam(value = "title", required = true) String title,
                             @RequestParam(value = "content", required = true) String content) {

        BoardDto boardDto = new BoardDto(title, content, username);
        boardService.write(boardDto);
        return "redirect:/board/list";
    }


}
