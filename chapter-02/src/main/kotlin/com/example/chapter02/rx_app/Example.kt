package com.example.chapter02.rx_app

import io.reactivex.rxjava3.core.Observable

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
}