package com.dw.mybatisloginterceptor.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class UserInfo {
    private String name;

    private String age;

    private String gender;

    private BigDecimal money;

    private String createdBy;

    private LocalDateTime createdTime;
}
