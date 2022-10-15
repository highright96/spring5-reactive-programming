package com.example.chapter02.rx_app

import org.springframework.stereotype.Component
import rx.Observable
import java.util.*
import java.util.concurrent.TimeUnit

@Component
class RxTemperatureSensor {
    private val rnd = Random()
    val dataStream = Observable.range(0, Int.MAX_VALUE)
        .concatMap { tick ->
            Observable.just(tick)
                .delay(rnd.nextInt(5000).toLong(), TimeUnit.MILLISECONDS)
                .map { this.probe() }
        }
        .publish()
        .refCount()

    private fun probe() = RxTemperature(16 + rnd.nextGaussian() * 10)
}