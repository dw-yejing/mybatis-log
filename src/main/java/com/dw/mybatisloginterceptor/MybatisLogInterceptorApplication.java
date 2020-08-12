package com.dw.mybatisloginterceptor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dw.mybatisloginterceptor.dao")
public class MybatisLogInterceptorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisLogInterceptorApplication.class, args);
    }

}
