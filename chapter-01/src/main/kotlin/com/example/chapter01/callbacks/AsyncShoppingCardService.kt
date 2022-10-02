package com.example.chapter01.callbacks

class AsyncShoppingCardService : ShoppingCardService {
    override fun calculate(input: Input) {
        Thread {
            println("in calculate...")
        }.start()
    }
}