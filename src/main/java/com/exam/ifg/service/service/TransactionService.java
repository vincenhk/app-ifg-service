package com.exam.ifg.service.service;

import com.exam.ifg.service.dto.request.TransactionRequestDto;
import com.exam.ifg.service.dto.response.TransactionResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.ws.rs.core.Response;

import java.text.ParseException;

public interface TransactionService {
    TransactionResponseDto transactionProcess(TransactionRequestDto requestDto) throws ParseException, JsonProcessingException;
}
