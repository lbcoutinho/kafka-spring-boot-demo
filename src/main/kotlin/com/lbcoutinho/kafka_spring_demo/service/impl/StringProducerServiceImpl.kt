package com.lbcoutinho.kafka_spring_demo.service.impl

import com.fasterxml.jackson.databind.ObjectMapper
import com.lbcoutinho.kafka_spring_demo.model.EventDto
import com.lbcoutinho.kafka_spring_demo.model.ProducerType
import com.lbcoutinho.kafka_spring_demo.model.ProducerType.STRING
import com.lbcoutinho.kafka_spring_demo.service.ProducerService
import com.lbcoutinho.kafka_spring_demo.util.STRING_TOPIC
import java.util.UUID
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Service

private val LOGGER = LoggerFactory.getLogger(StringProducerServiceImpl::class.java)

@Service
class StringProducerServiceImpl(
    private val kafkaTemplate: KafkaTemplate<String, String>,
    private val objectMapper: ObjectMapper
) : ProducerService {

    override fun produce(eventDto: EventDto): SendResult<String, String> {
        LOGGER.info("eventDto: {}", eventDto)
        val key = UUID.randomUUID().toString()
        val data = objectMapper.writeValueAsString(eventDto)
        LOGGER.info("Key: {} - Data: {}", key, data)
        val futureResult = kafkaTemplate.send(STRING_TOPIC, key, data)
        return futureResult.get()
    }

    override fun producerType(): ProducerType {
        return STRING
    }
}