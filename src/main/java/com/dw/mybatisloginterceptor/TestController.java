package com.dw.mybatisloginterceptor;

import com.dw.mybatisloginterceptor.dao.UserInfoDao;
import com.dw.mybatisloginterceptor.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RestController
public class TestController {
    @Autowired
    private UserInfoDao userInfoDao;

    @GetMapping("/test")
    public void test(){
        UserInfo userInfo = new UserInfo();
        userInfo.setName("a");
        userInfo.setAge("17");
        userInfo.setGender("1");
        BigDecimal m = new BigDecimal("11");
        String c = "tom";
        LocalDateTime d = LocalDateTime.now();
        userInfoDao.insertUser("a", null, "1", m, c, d);
    }
}
