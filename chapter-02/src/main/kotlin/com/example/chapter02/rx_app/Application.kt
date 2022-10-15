package com.example.chapter02.rx_app

import com.example.chapter02.Chapter02Application
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Application {}

fun main(args: Array<String>) {
    runApplication<Chapter02Application>(*args)
}