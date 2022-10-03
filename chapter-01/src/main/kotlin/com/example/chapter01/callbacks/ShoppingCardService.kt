package com.example.chapter01.callbacks

import com.example.chapter01.Input

interface ShoppingCardService {
    fun calculate(input: Input, block: () -> Unit)
}