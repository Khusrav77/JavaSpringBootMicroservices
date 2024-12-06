package com.shh.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
@Schema(
        name = "Customer",
        description = "Customer to hold Customer and Account information"
)
public class CustomerDto {

    @Schema(
            description = "Name of the customer", example = "Eazy Bytes"
    )
    @NotEmpty(message = "Name can not be a null or empty")
    @Size(min = 2, max = 20, message = "The length of the customer name should be between 5 and 20")
    private String name;


    @Schema(
            description = "Email address of the customer", example = "test@gmail.com"
    )
    @NotEmpty(message = "Email address con not be a null or empty")
    @Email(message = "Email address should be a valid value")
    private String email;


    @Schema(
            description = "Mobile Number of the customer", example = "+7 999 000 00 00"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;


    @Schema(
            description = "Account details of the customer"
    )
    private AccountsDto accountsDto;

}
