package com.lbcoutinho.kafka_spring_demo.model

data class ProducerResult(
    private val partition: Int,
    private val offset: Long,
    private val timestamp: Long,
    private val key: String?,
    private val value: String
)