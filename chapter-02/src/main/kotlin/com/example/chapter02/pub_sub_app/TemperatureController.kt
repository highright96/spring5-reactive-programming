package com.example.chapter02.pub_sub_app

import org.springframework.context.event.EventListener
import org.springframework.http.MediaType
import org.springframework.scheduling.annotation.Async
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter
import java.lang.Exception
import java.util.concurrent.CopyOnWriteArraySet
import javax.servlet.http.HttpServletRequest

@RestController
class TemperatureController {

    private val clients = CopyOnWriteArraySet<SseEmitter>()

    @GetMapping("/temperature-stream")
    fun event(request: HttpServletRequest): SseEmitter {
        val emitter = SseEmitter()
        clients.add(emitter)

        emitter.onTimeout { clients.remove(emitter) }
        emitter.onCompletion { clients.remove(emitter) }

        return emitter
    }

    @Async
    @EventListener
    fun handleMessage(temperature: Temperature) {
        val deadEmitters = ArrayList<SseEmitter>()
        clients.forEach { emitter ->
            try {
                emitter.send(temperature, MediaType.APPLICATION_JSON)
            } catch (exception: Exception) {
                deadEmitters.add(emitter)
            }
        }
        clients.removeAll(deadEmitters.toSet())
    }
}