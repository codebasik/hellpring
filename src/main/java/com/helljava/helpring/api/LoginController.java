package com.helljava.helpring.api;


import com.helljava.helpring.domain.User;
import com.helljava.helpring.service.LoginService;
import com.helljava.helpring.util.CookieBox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by yongjunjung on 2016. 8. 23..
 */

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    Logger log = LoggerFactory.getLogger(getClass());

    public static final String SAVE_ID_OK = "on";

    @Autowired
    private LoginService loginService;

    @RequestMapping(method = GET)
    public String login(Model model , HttpServletRequest request) throws IOException {

        CookieBox cookieBox = new CookieBox(request);
        request.setAttribute("c_id", cookieBox.getValue("c_id"));
        request.setAttribute("isSave", cookieBox.getValue("isSave"));

        return "login";
    }

    @RequestMapping(method = POST)
    public String login(@RequestParam(value = "userid", required = true) String userId,
                        @RequestParam(value = "userpassword", required = true) String userPassword,
                        @RequestParam(value = "isSave", required = false) String isSave,
                        HttpServletRequest request,
                        HttpServletResponse response,
                        Model model) throws IOException {

        log.info("[LOGIN] userId={} , userPassword={}", userId, userPassword);
        log.info("isSave={}", isSave);

        User user = loginService.login(userId);

        if (StringUtils.isEmpty(user)) {
            return "login";
        }

        setSessionAndCookie(isSave, request, response, user);

        return "redirect:/";
    }

    private void setSessionAndCookie(String isSave, HttpServletRequest request, HttpServletResponse response, User user) throws IOException {
        //로그인 성공한 사용자는 session 저장
        HttpSession session = request.getSession();
        session.setAttribute("s_id", user.getUsername());
        session.setMaxInactiveInterval(60 * 3);

        //아이디저장을 클릭한 사용자는 쿠키에 저장
        if (SAVE_ID_OK.equals(isSave)) {
            response.addCookie(CookieBox.createCookie("c_id", user.getUsername()));
            response.addCookie(CookieBox.createCookie("isSave", "Y"));
        } else {
            response.addCookie(CookieBox.createCookie("c_id", "", 0));
            response.addCookie(CookieBox.createCookie("isSave", "", 0));
        }
    }

}
