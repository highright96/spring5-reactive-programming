package com.example.chapter02.rx_app

import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

fun main() {
    /*
    Observable.create<String> { sub ->
        sub.onNext("Hello world!!")
        sub.onComplete()
    }.subscribe (
        { s -> println(s) },
        { e -> println(e) },
        { println("Done!") }
    )
    */

    Observable.just(1, 2, 3, 4)
        .subscribe(
            { s -> println(s) },
            { e -> println(e) },
            { println("Done!") }
        )

    Observable.interval(1, TimeUnit.SECONDS)
        .subscribe { event -> println("received $event") }
    //Thread.sleep(5000)

    Observable.zip(
        Observable.just("A", "B", "C"),
        Observable.just("1", "2", "3")
    ) { x, y -> x + y }
        .forEach { println(it) }
}