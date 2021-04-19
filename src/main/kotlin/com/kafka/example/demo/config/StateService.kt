package com.kafka.example.demo.config

import com.kafka.example.demo.model.JsonFriendlyModel
import org.apache.kafka.streams.kstream.KStream
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.function.Function

@Configuration
class StateService {
    @Bean
    fun state(): Function<KStream<String, JsonFriendlyModel>, KStream<String, String>> {
        return Function { input ->
            input.mapValues { v -> v.state }
        }
    }
}