package com.example.chapter02.observer

import java.util.concurrent.CopyOnWriteArraySet
import java.util.concurrent.Executors

class ConcreteSubject : Subject<String> {

    private val observers = CopyOnWriteArraySet<Observer<String>>()
    private val executorService = Executors.newCachedThreadPool()

    override fun registerObserver(observer: Observer<String>) {
        observers.add(observer)
    }

    override fun unregisterObserver(observer: Observer<String>) {
        observers.remove(observer)
    }

    override fun notifyObserver(event: String) {
        observers.forEach { observer ->
            executorService.submit {
                observer.observe(event)
            }
        }
        executorService.shutdown()
    }
}