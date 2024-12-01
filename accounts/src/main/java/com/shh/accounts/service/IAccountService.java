package com.shh.accounts.service;

import com.shh.accounts.dto.CustomerDto;
import com.shh.accounts.entity.Customer;

public interface IAccountService {


    void createAccount(CustomerDto customerDto);
}
