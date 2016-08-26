package com.helljava.helpring.service;

import com.helljava.helpring.domain.User;
import com.helljava.helpring.repository.LoginRespository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yongjunjung on 2016. 8. 23..
 */

public class LoginService {

    @Autowired
    LoginRespository loginRespository;

    public User login(String userId) {
        return loginRespository.findByUserIdAndPassword(userId);
    }

}
