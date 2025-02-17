package com.lbcoutinho.kafka_spring_demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaSpringBootDemoApplication

fun main(args: Array<String>) {
	runApplication<KafkaSpringBootDemoApplication>(*args)
}
