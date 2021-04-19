package com.kafka.example.demo.services

import com.kafka.example.demo.model.JsonFriendlyModel
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class ProducerService(val kafkaTemplate: KafkaTemplate<String, JsonFriendlyModel>) {

    val topicName = "sample-topic"

    fun sendMessage(jsonFriendlyModel: JsonFriendlyModel) {
        kafkaTemplate.send(topicName, jsonFriendlyModel.name!!, jsonFriendlyModel)
    }
}