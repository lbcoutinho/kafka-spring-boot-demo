package com.lbcoutinho.kafka_spring_demo.controller

import com.lbcoutinho.kafka_spring_demo.model.EventDto
import com.lbcoutinho.kafka_spring_demo.model.ProducerResult
import com.lbcoutinho.kafka_spring_demo.model.ProducerType
import com.lbcoutinho.kafka_spring_demo.service.ProducerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ProducerController(private val producerServices: List<ProducerService>) {

    @PostMapping("/v1/produce")
    fun produceEvent(
        @RequestParam("type") type: ProducerType,
        @RequestBody event: EventDto
    ): ResponseEntity<ProducerResult> {
        val producerService = producerServices.first { it.producerType() == type }
        val result = producerService.produce(event)
        return ResponseEntity.ok(
            ProducerResult(
                result.recordMetadata.partition(),
                result.recordMetadata.offset(),
                result.recordMetadata.timestamp(),
                result.producerRecord.key(),
                result.producerRecord.value().toString()
            )
        )
    }
}