package com.shh.accounts.controller;


import com.shh.accounts.constants.ConstantsAccount;
import com.shh.accounts.dto.CustomerDto;
import com.shh.accounts.dto.ResponseDto;
import com.shh.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.lang.reflect.Type;

@RestController
@RequestMapping(path="/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class AccountController {

    private IAccountService accountService;

    @PostMapping("/creat")
    public ResponseEntity<ResponseDto>createAccount(@RequestBody CustomerDto customerDto) {
      accountService.createAccount(customerDto);
        return ResponseEntity
              .status(HttpStatus.CREATED)
              .body(new ResponseDto(ConstantsAccount.STATUS_201, ConstantsAccount.MESSAGE_201));

    }

}
