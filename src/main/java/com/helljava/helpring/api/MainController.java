package com.helljava.helpring.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yongjunjung on 2016. 8. 23..
 */

@Controller
public class MainController {

    @RequestMapping(value = "/")
    public String main(Model model) {
        return "main";
    }
}
