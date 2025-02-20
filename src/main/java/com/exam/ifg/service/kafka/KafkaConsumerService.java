package com.exam.ifg.service.kafka;

import com.exam.ifg.service.dto.request.TransactionRequestDto;
import com.exam.ifg.service.util.MapperUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.smallrye.reactive.messaging.annotations.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@Slf4j
@ApplicationScoped
public class KafkaConsumerService {

    @Incoming("test")
    @Blocking
    public void sendTransaction(String message) throws JsonProcessingException {
        System.out.println("Received Kafka message: " + message);
        try {
            String strMessage = message;
            if(strMessage.contains("\\")){
                strMessage = strMessage.replace("\\","");
                log.info("strMessage : {}", strMessage);
            }
            log.info("Sent Kafka message to Object: {}", MapperUtil.jsonToObject(strMessage, TransactionRequestDto.class));
        } catch (Exception e) {
            log.error("failed convert json : {} ", e.getMessage());
        }

    }
}
