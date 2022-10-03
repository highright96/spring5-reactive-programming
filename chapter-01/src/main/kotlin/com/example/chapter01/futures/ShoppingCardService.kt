package com.example.chapter01.futures

import com.example.chapter01.Input
import com.example.chapter01.Output
import java.util.concurrent.Future

interface ShoppingCardService {
    fun calculate(input: Input): Future<Output>
}