package com.kafka.example.demo.services.generator

import com.fasterxml.jackson.databind.ObjectMapper
import com.kafka.example.demo.model.JsonFriendlyModel
import org.springframework.stereotype.Service
import java.io.File
import java.lang.Exception
import kotlin.random.Random

@Service
class SampleGenerator {
    private var index: Int
    private val samples: Array<JsonFriendlyModel>

    constructor() {
        val dataFile = "src/main/resources/data/models.json"
        val mapper = ObjectMapper()
        index = 0
        try {
            samples = mapper.readValue(File(dataFile), Array<JsonFriendlyModel>::class.java)
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    fun getNextSample() : JsonFriendlyModel {
        val jsonFriendlyModel = samples[index]
        index++
        return jsonFriendlyModel
    }
}