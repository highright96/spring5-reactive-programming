package com.example.chapter01.callbacks

import com.example.chapter01.Input

class AsyncShoppingCardService : ShoppingCardService {
    override fun calculate(input: Input, block: () -> Unit) {
        Thread {
            block()
        }.start()
    }
}