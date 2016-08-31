package com.helljava.helpring.config;

import com.helljava.helpring.repository.*;
import com.helljava.helpring.service.BoardService;
import com.helljava.helpring.service.JoinService;
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

    @Bean
    public BoardService boardService() {
        return new BoardService();
    }

    @Bean
    public BoardRepository boardRepository() {
        return new BoardRepositoryImpl(datasource);}

    @Bean
    public JoinService joinService() {
        return new JoinService();
    }

    @Bean
    public JoinRepository joinRepository() {
        return new JoinRepositoryImpl(datasource);
    }
}
