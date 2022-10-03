package com.example.chapter01.completions_stage

import com.example.chapter01.Input
import com.example.chapter01.Output
import java.util.concurrent.CompletableFuture

class CompletionStageShoppingCardService : ShoppingCardService {
    override fun calculate(value: Input): CompletableFuture<Output> =
        CompletableFuture.supplyAsync {
            try {
                Thread.sleep(1000)
            } catch (e: Exception) {
                e.stackTrace
            }
            Output()
        }
}