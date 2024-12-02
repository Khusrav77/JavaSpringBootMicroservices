package com.shh.accounts.entity;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;


@MappedSuperclass
@Getter @Setter @ToString
public class BaseEntity {

    @Column(updatable = false)
    private LocalDateTime creatAt;

    @Column(insertable = false)
    private String creatBy;

    @Column(updatable = false)
    private LocalDateTime updateAt;

    @Column(insertable = false)
    private String updateBy;
}
