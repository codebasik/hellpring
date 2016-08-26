package com.helljava.helpring.service;

import com.helljava.helpring.domain.User;
import com.helljava.helpring.repository.LoginRespository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yongjunjung on 2016. 8. 23..
 */
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginRespository loginRespository;

    @Override
    public User login(String userId) {
        return loginRespository.findByUserIdAndPassword(userId);
    }

}
