package com.helljava.helpring.api;

import com.helljava.helpring.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by yongjunjung on 2016. 8. 31..
 */

@Controller
public class JoinController {

    @Autowired
    JoinService joinService;

    @RequestMapping(value = "/register", method = GET)
    public String join(Model model) {
        return "register";
    }

    @RequestMapping(value = "/join", method = POST)
    public String join(Model model,
                       @RequestParam(value = "userid", required = true) String userid,
                       @RequestParam(value = "username", required = true) String username,
                       @RequestParam(value = "userpassword", required = true) String userpassword,
                       @RequestParam(value = "useremail", required = true) String useremail,
                       HttpServletRequest request) {

        joinService.save(userid, username, userpassword, useremail);

        HttpSession session = request.getSession();
        session.setAttribute("s_id", userid);
        session.setMaxInactiveInterval(60 * 3);                         //로그인시간 3*60초

        return "redirect:/";
    }
}
