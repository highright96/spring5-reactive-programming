package com.example.chapter01.completions_stage

import com.example.chapter01.Input
import com.example.chapter01.Output
import java.util.concurrent.CompletionStage

interface ShoppingCardService {
    fun calculate(value: Input): CompletionStage<Output>
}