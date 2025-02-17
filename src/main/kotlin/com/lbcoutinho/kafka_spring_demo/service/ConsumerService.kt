package com.lbcoutinho.kafka_spring_demo.service

import com.lbcoutinho.kafka_spring_demo.util.TOPIC_NAME
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

private val LOGGER = LoggerFactory.getLogger(ConsumerService::class.java)

@Service
class ConsumerService {

    @KafkaListener(topics = [TOPIC_NAME], groupId = "my-group-1")
    fun consume(message: String) {
        LOGGER.info("Consumed event: {}", message)
    }
}