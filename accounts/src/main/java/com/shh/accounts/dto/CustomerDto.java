package com.shh.accounts.dto;

import lombok.Data;


@Data
public class CustomerDto {

    private AccountsDto accountsDto;

    private String name;
    private String email;
    private String mobileNumber;

}
