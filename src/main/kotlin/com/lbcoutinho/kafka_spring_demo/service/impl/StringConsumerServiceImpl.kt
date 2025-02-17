package com.lbcoutinho.kafka_spring_demo.service.impl

import com.lbcoutinho.kafka_spring_demo.util.STRING_TOPIC
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

private val LOGGER = LoggerFactory.getLogger(StringConsumerServiceImpl::class.java)

@Service
class StringConsumerServiceImpl {

    @KafkaListener(topics = [STRING_TOPIC], groupId = "my-group-1")
    fun consume(event: String) {
        LOGGER.info("Consumed String event: {}", event)
    }
}