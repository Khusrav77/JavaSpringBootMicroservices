package com.shh.accounts.entity;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter @Setter
@ToString
public class BaseEntity {

    @Column(updatable = false)
    private LocalDateTime creatAt;
    @Column(insertable = false)
    private LocalDateTime creatBy;

    @Column(updatable = false)
    private String updateAt;
    @Column(insertable = false)
    private String updateBy;
}
