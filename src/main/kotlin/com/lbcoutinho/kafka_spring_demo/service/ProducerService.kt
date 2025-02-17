package com.lbcoutinho.kafka_spring_demo.service

import com.lbcoutinho.kafka_spring_demo.model.EventDto
import com.lbcoutinho.kafka_spring_demo.model.ProducerType
import org.springframework.kafka.support.SendResult

interface ProducerService {

    fun produce(eventDto: EventDto): SendResult<String, *>

    fun producerType(): ProducerType
}
