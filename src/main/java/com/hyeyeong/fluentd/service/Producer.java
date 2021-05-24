package com.hyeyeong.fluentd.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Producer {
    private static final Logger LOG = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "test";
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        LOG.info(String.format("#### -> Producing message -> %s", message));
        kafkaTemplate.send(TOPIC, message);
    }
}
