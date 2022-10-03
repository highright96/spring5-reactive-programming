package com.example.chapter01.callbacks

import com.example.chapter01.Input

class SyncShoppingCardService : ShoppingCardService {
    override fun calculate(input: Input, block: () -> Unit) {
        block()
    }
}