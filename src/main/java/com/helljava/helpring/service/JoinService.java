package com.helljava.helpring.service;

import com.helljava.helpring.repository.JoinRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yongjunjung on 2016. 8. 31..
 */
public class JoinService {

    @Autowired
    JoinRepository joinRepository;

    public void save(String id, String name, String password, String email) {
        joinRepository.save(id, name, password, email);
    }
}
