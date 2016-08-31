package com.helljava.helpring.repository;

/**
 * Created by yongjunjung on 2016. 8. 31..
 */
public interface JoinRepository {

    void save(String id, String name, String password, String email);
}
