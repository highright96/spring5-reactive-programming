package com.example.chapter01.callbacks

class SyncShoppingCardService : ShoppingCardService {
    override fun calculate(input: Input) {
        println("in calculate...")
    }
}