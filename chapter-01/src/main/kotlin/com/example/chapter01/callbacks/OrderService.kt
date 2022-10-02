package com.example.chapter01.callbacks

class OrderService(
    private val shoppingCardService: ShoppingCardService
) {

    fun process() {
        val input = Input()
        println("process start...")
        shoppingCardService.calculate(input)
        println("process end...")
    }
}

fun main() {
    val orderService = OrderService(AsyncShoppingCardService())
    orderService.process()
}