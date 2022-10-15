package com.example.chapter02.rx_app

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter
import rx.Subscriber

const val SSE_SESSION_TIMEOUT = 30 * 50 * 1000L

class RxSeeEmitter : SseEmitter(SSE_SESSION_TIMEOUT) {
    val subscriber: Subscriber<RxTemperature>

    init {
        subscriber = object : Subscriber<RxTemperature>() {
            override fun onCompleted() {}
            override fun onError(t: Throwable) {}
            override fun onNext(t: RxTemperature) {
                runCatching {
                    send(t)
                }.getOrElse {
                    unsubscribe()
                }
            }
        }
        onCompletion { subscriber.unsubscribe() }
        onError { subscriber.unsubscribe() }
    }
}