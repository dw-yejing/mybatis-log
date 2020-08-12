package com.dw.mybatisloginterceptor.config;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisConfig {
    @Bean
    ConfigurationCustomizer mybatisConfigurationCustomizer() {
        return (org.apache.ibatis.session.Configuration configuration)->configuration.addInterceptor(new MybatisLogInterceptor());
    }
}
