package com.shh.accounts.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Accounts extends BaseEntity {

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "account_id")
    @Id
    private Long accountId;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "branch_address")
    private String branchAddress;

}
