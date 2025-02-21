package com.exam.ifg.service.dto.response;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponseDto {
    private String transactionId;
    private Long userId;
    private BigDecimal amount;
    private String currency;
    private String transactionType;
    private String processAt;
    private String status;
}
