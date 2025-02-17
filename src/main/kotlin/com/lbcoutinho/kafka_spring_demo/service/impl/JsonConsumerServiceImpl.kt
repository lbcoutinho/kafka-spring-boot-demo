package com.lbcoutinho.kafka_spring_demo.service.impl

import com.lbcoutinho.kafka_spring_demo.model.EventDto
import com.lbcoutinho.kafka_spring_demo.util.JSON_TOPIC
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

private val LOGGER = LoggerFactory.getLogger(JsonConsumerServiceImpl::class.java)

@Service
class JsonConsumerServiceImpl {

    @KafkaListener(topics = [JSON_TOPIC], groupId = "my-group-1")
    fun consume(event: EventDto) {
        LOGGER.info("Consumed JSON event: {}", event)
    }
}