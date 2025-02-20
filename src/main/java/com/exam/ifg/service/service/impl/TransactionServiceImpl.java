package com.exam.ifg.service.service.impl;

import com.exam.ifg.service.dto.request.TransactionRequestDto;
import com.exam.ifg.service.dto.response.TransactionResponseDto;
import com.exam.ifg.service.enums.CurrencyType;
import com.exam.ifg.service.enums.StatusTransaction;
import com.exam.ifg.service.enums.TransactionDirection;
import com.exam.ifg.service.enums.TransactionType;
import com.exam.ifg.service.model.Balance;
import com.exam.ifg.service.model.Transactions;
import com.exam.ifg.service.model.TransactionsDtl;
import com.exam.ifg.service.model.Users;
import com.exam.ifg.service.repository.BalanceRepository;
import com.exam.ifg.service.repository.TransactionDtlRepository;
import com.exam.ifg.service.repository.TransactionRepository;
import com.exam.ifg.service.repository.UsersRepository;
import com.exam.ifg.service.service.TransactionService;
import com.exam.ifg.service.util.DateUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.text.ParseException;

@ApplicationScoped
public class TransactionServiceImpl implements TransactionService {

    @Inject
    TransactionRepository transactionRepository;
    @Inject
    UsersRepository usersRepository;
    @Inject
    TransactionDtlRepository transactionDtlRepository;
    @Inject
    BalanceRepository balanceRepository;

    public TransactionResponseDto transactionProcess(TransactionRequestDto requestDto) throws ParseException {

        Transactions transactions = new Transactions();

        Users user = usersRepository.findById(requestDto.getUserId());

        if (user == null) throw new IllegalArgumentException("User not found with ID : " + requestDto.getUserId());
        transactions.setUser(user);
        transactions.setTrxCode(requestDto.getTransactionId());
        transactions.setAmount(requestDto.getAmount());
        transactions.setCurrency(CurrencyType.valueOf(requestDto.getCurrency()));
        transactions.setTransactionTime(DateUtil.convertStringToTimestamp(requestDto.getTimeTransaction()));
        transactions.setTransactionDirection(TransactionDirection.valueOf(requestDto.getTransactionDirection()));

        TransactionsDtl transactionsDtl = new TransactionsDtl();

        transactionsDtl.setTransaction(transactions);
        transactionsDtl.setTransactionType(TransactionType.valueOf(requestDto.getTransactionType()));
        transactionsDtl.setStatus(StatusTransaction.valueOf(requestDto.getStatus()));
        transactionsDtl.setDescription(requestDto.getDescription());

        transactionRepository.persist(transactions);
        transactionDtlRepository.persist(transactionsDtl);
        balanceRepository.persist(operationBalance(requestDto, user));


        TransactionResponseDto responseDto = new TransactionResponseDto();
        responseDto.setTransactionId(transactions.getTrxCode());
        responseDto.setUserId(user.getId());
        responseDto.setAmount(transactions.getAmount());
        responseDto.setCurrency(requestDto.getCurrency());
        responseDto.setTransactionType(requestDto.getTransactionType());
        responseDto.setStatus(requestDto.getStatus());
        responseDto.setProcessAt(DateUtil.currentTimeJakarta().toString());

        return responseDto;
    }

    public Balance operationBalance(TransactionRequestDto requestDto, Users user) {

        Balance balance = balanceRepository.findByUserId(user.getId());
        String operation = TransactionDirection.valueOf(requestDto.getTransactionDirection()).getValue();

        if (operation.equals("+")) {
            balance.setBalanceAmount(balance.getBalanceAmount().add(requestDto.getAmount()));
            balance.setCurrency(CurrencyType.valueOf(requestDto.getCurrency()));
            balance.setLastUpdated(DateUtil.currentTimeJakarta());
        }else{
            if(balance.getBalanceAmount().compareTo(requestDto.getAmount()) > 0){
                balance.setBalanceAmount(balance.getBalanceAmount().subtract(requestDto.getAmount()));
                balance.setCurrency(CurrencyType.valueOf(requestDto.getCurrency()));
                balance.setLastUpdated(DateUtil.currentTimeJakarta());
            }else{
                throw new IllegalArgumentException("Withdraw amount is greater than balance amount.");
            }
        }

        return balance;
    }


}
