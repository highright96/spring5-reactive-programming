package com.example.chapter02.observer

interface Subject<T> {
    fun registerObserver(observer: Observer<T>)
    fun unregisterObserver(observer: Observer<T>)
    fun notifyObserver(event: T)
}