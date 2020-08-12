package com.dw.mybatisloginterceptor.dao;

import com.dw.mybatisloginterceptor.entity.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Repository
public interface UserInfoDao {
    @Insert("insert into user_info values(#{name}, #{age}, #{gender}, #{m}, #{c}, #{d})")
    int insertUser(@Param("name") String name, @Param("age")String age, @Param("gender") String gender, @Param("m") BigDecimal m, @Param("c") String c, @Param("d") LocalDateTime d);
}
