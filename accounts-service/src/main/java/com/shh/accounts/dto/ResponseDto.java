package com.shh.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
@Schema(
        name = "Response",
        description = "Schema to hold successful response information"
)
public class ResponseDto {
    @Schema(
            description = "Schema code in the response", example = "200"
    )
    private String statusCode;


    @Schema(
            description = "Schema message in the response", example = "Request processed successfully"
    )
    private String statusMessage;
}
