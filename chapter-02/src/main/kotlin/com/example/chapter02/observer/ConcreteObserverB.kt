package com.example.chapter02.observer

class ConcreteObserverB : Observer<String> {
    override fun observe(event: String) {
        println("Observer B : $event")
    }
}