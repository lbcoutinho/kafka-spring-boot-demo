package com.lbcoutinho.kafka_spring_demo.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.lbcoutinho.kafka_spring_demo.model.EventDto
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Service
import java.util.UUID.randomUUID

private val LOGGER = LoggerFactory.getLogger(ProducerService::class.java)

@Service
class ProducerService(
    private val kafkaTemplate: KafkaTemplate<String, String>,
    private val objectMapper: ObjectMapper
) {

    fun produce(eventDto: EventDto): SendResult<String, String> {
        LOGGER.info("eventDto: {}", eventDto)
        val topicName = "test-topic"
        val key = randomUUID().toString()
        val data = objectMapper.writeValueAsString(eventDto)
        LOGGER.info("Key: {} - Data: {}", key, data)
        val futureResult = kafkaTemplate.send(topicName, key, data)
        return futureResult.get()
    }
}
