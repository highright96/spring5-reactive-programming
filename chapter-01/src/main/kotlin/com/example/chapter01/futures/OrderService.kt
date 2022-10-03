package com.example.chapter01.futures

import com.example.chapter01.Input

class OrderService(
    private val shoppingCardService: ShoppingCardService
) {

    fun process() {
        val input = Input()
        println("process start...")
        val future = shoppingCardService.calculate(input)
        try {
            future.get()
        } catch (e: Exception) {
            println(e.stackTrace)
        }
        println("process end...")
    }
}

fun main() {
    val orderService = OrderService(FutureShoppingCardService())
    orderService.process()
}