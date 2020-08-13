package com.dw.mybatisloginterceptor;

import com.dw.mybatisloginterceptor.dao.UserInfoIbatisDao;
import com.dw.mybatisloginterceptor.entity.UserInfo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootApplication
public class MybatisLogInterceptorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisLogInterceptorApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(UserInfoIbatisDao userInfoIbatisDao){
        return args -> {
            userInfoIbatisDao.insert(new UserInfo("1", "jabin", "18", "1", new BigDecimal("100000"), "admin", LocalDateTime.now()));
        };
    }
}
