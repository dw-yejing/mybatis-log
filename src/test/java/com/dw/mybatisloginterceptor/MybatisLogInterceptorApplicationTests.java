package com.dw.mybatisloginterceptor;

import com.dw.mybatisloginterceptor.dao.UserInfoDao;
import com.dw.mybatisloginterceptor.entity.UserInfo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisLogInterceptorApplicationTests {
    @Autowired
    private UserInfoDao userInfoDao;

    @Test
    void contextLoads() {

    }

}
