package com.shh.accounts.mapper;

import com.shh.accounts.dto.AccountsDto;
import com.shh.accounts.entity.Accounts;

public class AccountMapper {

    public static AccountsDto mapToAccountDto(Accounts accounts, AccountsDto accountsDto) {
        accountsDto.setAccountId(accounts.getAccountId());
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setBranchAddress(accounts.getBranchAddress());
        return accountsDto;
    }

    public static Accounts mapToAccounts(AccountsDto accountsDto, Accounts accounts) {
        accounts.setAccountId(accountsDto.getAccountId());
        accounts.setAccountType(accountsDto.getAccountType());
        accounts.setBranchAddress(accountsDto.getBranchAddress());
        return accounts;
    }
}
