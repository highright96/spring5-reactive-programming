package com.example.chapter02

import com.example.chapter02.observer.ConcreteObserverA
import com.example.chapter02.observer.ConcreteObserverB
import com.example.chapter02.observer.ConcreteSubject

fun main() {
    val subject = ConcreteSubject()
    val observerA = ConcreteObserverA()
    val observerB = ConcreteObserverB()

    subject.registerObserver(observerA)
    subject.registerObserver(observerB)
    subject.notifyObserver("message event!!")
}