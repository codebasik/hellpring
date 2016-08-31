package com.helljava.helpring.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by yongjunjung on 2016. 8. 31..
 */

@Controller
public class LogoutController {

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        session.invalidate();

        return "redirect:/";
    }
}
