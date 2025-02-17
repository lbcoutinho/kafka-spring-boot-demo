package com.lbcoutinho.kafka_spring_demo.service.impl

import com.lbcoutinho.kafka_spring_demo.model.EventDto
import com.lbcoutinho.kafka_spring_demo.model.ProducerType
import com.lbcoutinho.kafka_spring_demo.model.ProducerType.JSON
import com.lbcoutinho.kafka_spring_demo.service.ProducerService
import com.lbcoutinho.kafka_spring_demo.util.JSON_TOPIC
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.kafka.support.SendResult
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Service

@Service
class JsonProducerServiceImpl(private val kafkaTemplate: KafkaTemplate<String, EventDto>) : ProducerService {

    override fun produce(eventDto: EventDto): SendResult<String, EventDto> {
        val message = MessageBuilder
            .withPayload(eventDto)
            .setHeader(KafkaHeaders.TOPIC, JSON_TOPIC)
            .build()
        val futureResult = kafkaTemplate.send(message)
        return futureResult.get()
    }

    override fun producerType(): ProducerType {
        return JSON
    }
}