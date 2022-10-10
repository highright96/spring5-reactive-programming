package com.example.chapter02.pub_sub_app

import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component
import java.util.Random
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import javax.annotation.PostConstruct

@Component
class TemperatureSensor(
    private val publisher: ApplicationEventPublisher,
) {
    private val rnd = Random()
    private val executor = Executors.newSingleThreadScheduledExecutor()

    @PostConstruct
    fun startProcessing() {
        this.executor.schedule(this::probe, 1, TimeUnit.SECONDS)
    }

    fun probe() {
        val temperature = 16 + rnd.nextGaussian() * 10
        publisher.publishEvent(Temperature(temperature))
        this.executor.schedule(this::probe, rnd.nextInt(5000).toLong(), TimeUnit.MILLISECONDS)
    }
}