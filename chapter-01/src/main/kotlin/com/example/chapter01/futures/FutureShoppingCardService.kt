package com.example.chapter01.futures

import com.example.chapter01.Input
import com.example.chapter01.Output
import java.util.concurrent.Future
import java.util.concurrent.FutureTask

class FutureShoppingCardService : ShoppingCardService {
    override fun calculate(input: Input): Future<Output> {
        val future = FutureTask {
            println("futureShoppingCardService execution completed")
            Output()
        }
        Thread(future).start()
        return future
    }
}