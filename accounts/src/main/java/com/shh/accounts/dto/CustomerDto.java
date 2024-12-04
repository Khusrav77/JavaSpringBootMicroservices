package com.shh.accounts.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class CustomerDto {

    @NotEmpty(message = "Name can not be a null or empty")
    @Size(min = 2, max = 20, message = "The length of the customer name should be between 5 and 20")
    private String name;

    @NotEmpty(message = "Email address con not be a null or empty")
    @Email(message = "Email address should be a valid value")
    private String email;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    private AccountsDto accountsDto;

}
