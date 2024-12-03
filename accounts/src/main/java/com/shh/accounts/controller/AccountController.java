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



@RestController
@RequestMapping(path="/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class AccountController {

    private IAccountService accountService;


    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto) {
      accountService.createAccount(customerDto);
        return ResponseEntity
              .status(HttpStatus.CREATED)
              .body(new ResponseDto(ConstantsAccount.STATUS_201, ConstantsAccount.MESSAGE_201));

    }


    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccounts(@RequestBody String mobileNumber) {
        CustomerDto customerDto = accountService.fetchAccount(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccount(@RequestBody CustomerDto customerDto) {
        boolean isUpdated = accountService.updateAccount(customerDto);
        if (isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(ConstantsAccount.STATUS_200, ConstantsAccount.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(ConstantsAccount.STATUS_500, ConstantsAccount.MESSAGE_500));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteAccount(@RequestParam String mobileNumber) {
        boolean isDeleted = accountService.deleteAccount(mobileNumber);
        if (isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(ConstantsAccount.STATUS_200, ConstantsAccount.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(ConstantsAccount.STATUS_500, ConstantsAccount.MESSAGE_500));
        }
    }
}
