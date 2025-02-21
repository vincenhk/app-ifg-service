package com.exam.ifg.service.kafka;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import java.time.Instant;
import java.util.Properties;

@ApplicationScoped
public class KafkaProducerService {

    @ConfigProperty(name = "quarkus.messaging.bootstrap-servers", defaultValue = "localhost:9092")
    private String bootstrapServers;

    @ConfigProperty(name = "quarkus.messaging.outgoing.my-producer.topic", defaultValue = "my-topic")
    private String topic;

    private KafkaProducer<String, String> producer;


    // Setup Kafka Producer configuration
    @PostConstruct
    public void init() {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        producer = new KafkaProducer<>(properties);
    }

    public void sendMessage(String message) {
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, message);
        producer.send(record, (metadata, exception) -> {
            if (exception != null) {
                System.out.println("Error sending message to Kafka: " + exception.getMessage());
            } else {
                System.out.println("Message sent to Kafka: " + metadata.topic());
            }
        });
    }


}
