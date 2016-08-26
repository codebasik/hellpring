package com.helljava.helpring.config;

import com.helljava.helpring.repository.LoginRepositoryImpl;
import com.helljava.helpring.repository.LoginRespository;
import com.helljava.helpring.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

/**
 * Created by yongjunjung on 2016. 8. 23..
 */

@Import(H2DbConfig.class)
@Configuration
public class JavaConfig {

    @Autowired
    private DataSource datasource;

    @Bean
    public LoginService loginService() {
        return new LoginService();
    }

    @Bean
    public LoginRespository loginRespository() {
        return new LoginRepositoryImpl(datasource);
    }

}
