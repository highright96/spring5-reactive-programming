package com.example.chapter02

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.AsyncConfigurer
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import java.util.concurrent.Executor

@EnableAsync
@SpringBootApplication
class Chapter02Application : AsyncConfigurer {
	override fun getAsyncExecutor() = ThreadPoolTaskExecutor().apply {
			this.corePoolSize = 2
			this.maxPoolSize = 100
			this.queueCapacity = 5
			this.initialize()
		}

	override fun getAsyncUncaughtExceptionHandler() = SimpleAsyncUncaughtExceptionHandler()
}

fun main(args: Array<String>) {
	runApplication<Chapter02Application>(*args)
}
