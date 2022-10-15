package com.example.chapter02.rx_app

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter
import javax.servlet.http.HttpServletRequest

@RestController
class RxTemperatureController(
    private val rxTemperatureSensor: RxTemperatureSensor
) {

    @GetMapping("/temperature-stream")
    fun events(request: HttpServletRequest): SseEmitter {
        val emitter = RxSeeEmitter()
        rxTemperatureSensor.dataStream
            .subscribe(emitter.subscriber)
        return emitter
    }
}