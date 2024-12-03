package com.shh.accounts.service.impl;

import com.shh.accounts.constants.ConstantsAccount;
import com.shh.accounts.dto.AccountsDto;
import com.shh.accounts.dto.CustomerDto;
import com.shh.accounts.entity.Accounts;
import com.shh.accounts.entity.Customer;
import com.shh.accounts.exception.CustomerAlreadyExistsException;
import com.shh.accounts.exception.ResourceNotFoundExceptions;
import com.shh.accounts.mapper.AccountMapper;
import com.shh.accounts.mapper.CustomerMapper;
import com.shh.accounts.repository.AccountRepository;
import com.shh.accounts.repository.CustomerRepository;
import com.shh.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;


    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        Optional<Customer> byMobileNumber = customerRepository.findByMobileNumber(customer.getMobileNumber());
        if (byMobileNumber.isPresent()) {
           throw new CustomerAlreadyExistsException(
                   "Customer already registered with mobile number: " + customer.getMobileNumber());
       }
        customer.setCreatAt(LocalDateTime.now());
        customer.setCreatBy("Anonymous");
        Customer savedCustomer = customerRepository.save(customer);
        accountRepository.save(creatNewAccount(savedCustomer));
    }


    private Accounts creatNewAccount(Customer customer) {
       Accounts newAccount = new Accounts();
       newAccount.setCustomerId(customer.getCustomerId());
       long rondomId = 1000000000L + new Random().nextLong(900000000);

       newAccount.setAccountId(rondomId);
       newAccount.setAccountType(ConstantsAccount.SAVINGS);
       newAccount.setBranchAddress(ConstantsAccount.ADDRESS);
       newAccount.setCreatAt(LocalDateTime.now());
       newAccount.setCreatBy("Anonymous");
       return newAccount;
    }


    @Override
    public CustomerDto fetchAccount(String mobileNumber) {

        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundExceptions("Customer", "mobileNumber", mobileNumber)
        );

        Accounts accounts = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundExceptions("Account", "customerId", customer.getCustomerId().toString())
        );

        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
        customerDto.setAccountsDto(AccountMapper.mapToAccountDto(accounts, new AccountsDto()));
        return customerDto;
    }


    @Override
    public boolean updateAccount(CustomerDto customerDto) {
       boolean isUpdated = false;
       AccountsDto accountsDto = customerDto.getAccountsDto();

       if (accountsDto != null) {
           Accounts accounts = accountRepository.findById(accountsDto.getAccountId()).orElseThrow(
                   () -> new ResourceNotFoundExceptions("Account", "AccountId", accountsDto.getAccountId().toString()));

           AccountMapper.mapToAccounts(accountsDto, accounts);
           accounts = accountRepository.save(accounts);

           Long customerId = accounts.getCustomerId();
           Customer customer = customerRepository.findById(customerId).orElseThrow(
                    () -> new ResourceNotFoundExceptions("Customer", "CustomerId", customerId.toString()));

           CustomerMapper.mapToCustomer(customerDto, customer);
           customerRepository.save(customer);
           isUpdated = true;
       };

        return isUpdated;
    }


    @Override
    public boolean deleteAccount(String mobileNumber) {
        return false;
    }
}
