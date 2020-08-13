package com.dw.mybatisloginterceptor.dao;

import com.dw.mybatisloginterceptor.entity.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserInfoIbatisDao {
    @Insert("insert into user_info(id, name, age, gender, money, created_By, created_Time) values(#{id}, #{name}, #{age}, #{gender}, #{money}, #{createdBy}, #{createdTime})")
    int insert(UserInfo userInfo);
}
