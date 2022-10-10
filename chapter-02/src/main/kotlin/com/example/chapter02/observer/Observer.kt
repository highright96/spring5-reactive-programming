package com.example.chapter02.observer

interface Observer<T> {
    fun observe(event: T)
}