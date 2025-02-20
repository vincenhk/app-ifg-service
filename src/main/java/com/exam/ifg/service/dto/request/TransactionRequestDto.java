package com.exam.ifg.service.dto.request;


import com.exam.ifg.service.common.Constant;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionRequestDto {
    @NotBlank(message = "Transaction Id can't empty!")
    private String transactionId;
    @NotBlank(message = "User Id can't empty!")
    private Long userId;
    @Positive(message = "Amount must more than 0")
    private BigDecimal amount;
    private String currency;
    @NotBlank(message = "Time Transaction can't empty!")
    @Pattern(
            regexp = "^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$",
            message = "Time Transaction must be in the format yyyy-MM-dd HH:mm:ss"
    )
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constant.FULL_DATE)
    private String timeTransaction;
    @NotBlank(message = "Time Transaction can't empty!")
    private String transactionType;
    @NotBlank(message = "Time Transaction can't empty!")
    private String transactionDirection;
    @NotBlank(message = "Status can't empty!")
    private String status;
    private String description;

}
