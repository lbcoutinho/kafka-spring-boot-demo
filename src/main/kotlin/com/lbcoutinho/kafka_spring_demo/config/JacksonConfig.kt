package com.lbcoutinho.kafka_spring_demo.config

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY
import com.fasterxml.jackson.annotation.PropertyAccessor.FIELD
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JacksonConfig {

    @Bean
    fun objectMapper(): ObjectMapper {
        val objMapper = ObjectMapper()
        objMapper.registerKotlinModule()
        objMapper.setVisibility(FIELD, ANY)
        return objMapper
    }
}