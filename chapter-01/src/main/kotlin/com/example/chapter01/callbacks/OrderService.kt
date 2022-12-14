package com.example.chapter01.callbacks

import com.example.chapter01.Input

class OrderService(
    private val shoppingCardService: ShoppingCardService
) {
    fun process() {
        val input = Input()
        println("process start...")
        shoppingCardService.calculate(input) {
            println("${shoppingCardService.javaClass.simpleName} execution completed")
        }
        println("process end...")
    }
}

fun main() {
    val orderService = OrderService(SyncShoppingCardService())
    orderService.process()
}