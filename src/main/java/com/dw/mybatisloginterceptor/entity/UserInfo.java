package com.dw.mybatisloginterceptor.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserInfo {
    @Id
    private String id;

    private String name;

    private String age;

    private String gender;

    private BigDecimal money;

    private String createdBy;

    private LocalDateTime createdTime;
}
