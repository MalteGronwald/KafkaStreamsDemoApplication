package com.kafka.example.demo.services

import com.kafka.example.demo.services.generator.SampleGenerator
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class ProducerRunner(val producerService: ProducerService, val sampleGenerator: SampleGenerator) : ApplicationRunner{

    override fun run(args: ApplicationArguments?) {
        for (i in 0..4) {
            producerService.sendMessage(sampleGenerator.getNextSample())
            Thread.sleep(1000)
        }
    }
}