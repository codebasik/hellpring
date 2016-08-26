package com.helljava.helpring.repository;

import com.helljava.helpring.domain.User;

/**
 * Created by yongjunjung on 2016. 8. 23..
 */

public interface LoginRespository {

    User findByUserIdAndPassword(String id);


}
