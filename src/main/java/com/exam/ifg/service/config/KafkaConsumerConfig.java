//package com.exam.ifg.service.config;
//
//import io.smallrye.reactive.messaging.kafka.KafkaConsumer;
//import jakarta.enterprise.context.ApplicationScoped;
//import jakarta.inject.Inject;
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.common.serialization.StringDeserializer;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@ApplicationScoped
//public class KafkaConsumerConfig {
//
//    private KafkaConsumer<String, String> consumer;
//
//    @Inject
//    public KafkaConsumerService() {
//        Map<String, String> config = new HashMap<>();
//        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        config.put(ConsumerConfig.GROUP_ID_CONFIG, "my-consumer-group");
//        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
//        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
//        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
//
//        this.consumer = consumer.create(io.vertx.mutiny.core.Vertx.vertx(), config);
//    }
//
//}
