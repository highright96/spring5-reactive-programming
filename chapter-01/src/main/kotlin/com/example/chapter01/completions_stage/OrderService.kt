package com.example.chapter01.completions_stage

import com.example.chapter01.Input

class OrderService(
    private val shoppingCardService: ShoppingCardService
) {

    fun process() {
        val input = Input()
        println("process start...")
        shoppingCardService.calculate(input)
            .thenAccept {
                println("${shoppingCardService.javaClass.simpleName} execution completed")
            }
        println("process end...")
    }
}

fun main() {
    val service = OrderService(CompletionStageShoppingCardService())
    service.process()
}

