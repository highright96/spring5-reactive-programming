package com.example.chapter02.rx_app

import io.reactivex.rxjava3.core.Observable
import org.reactivestreams.Subscriber


interface RxObserver<T> {
    fun onNext(next: T)
    fun onComplete()
    fun onError(e: Exception)
}