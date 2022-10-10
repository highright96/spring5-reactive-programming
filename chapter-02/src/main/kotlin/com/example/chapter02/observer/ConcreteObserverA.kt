package com.example.chapter02.observer

class ConcreteObserverA : Observer<String> {
    override fun observe(event: String) {
        Thread.sleep(1000)
        println("Observer A : $event")
    }
}