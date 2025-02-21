package com.exam.ifg.service.kafka;

import com.exam.ifg.service.common.Constant;
import com.exam.ifg.service.dto.GlobalSuccessResponseDto;
import com.exam.ifg.service.dto.request.TransactionRequestDto;
import com.exam.ifg.service.dto.response.TransactionResponseDto;
import com.exam.ifg.service.service.TransactionService;
import com.exam.ifg.service.util.MapperUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.smallrye.reactive.messaging.annotations.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ApplicationScoped
public class KafkaConsumerService {

    @Inject
    KafkaProducerService kafkaProducerService;
    @Inject
    TransactionService transactionService;

    @Incoming("test")
    @Blocking
    public void sendTransaction(String message) throws JsonProcessingException {
        System.out.println("Received Kafka message: " + message);
        try {
            String strMessage = message;
            if (strMessage.contains("\\")) {
                strMessage = strMessage.replace("\\", "");
                log.info("strMessage : {}", strMessage);
            }
            TransactionRequestDto requestDto = MapperUtil.jsonToObject(strMessage, TransactionRequestDto.class);
            log.info("Sent Kafka message to Object: {}", requestDto);
            System.out.println("Sent Kafka message to Object");

            TransactionResponseDto responseDto = transactionService.transactionProcess(requestDto);

            kafkaProducerService.sendMessage(
                    MapperUtil.objectToJson(new GlobalSuccessResponseDto<>(Constant.SUCCESS_STATUS, responseDto)));
            System.out.println("end");
        } catch (Exception e) {
            log.error("Failed receive & run task message : {} ", e.getMessage());
        }
    }
}
