package com.sothawo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class KotlinSpringLoggerInjectionApplication

fun main(args: Array<String>) {
    SpringApplication.run(KotlinSpringLoggerInjectionApplication::class.java, *args)
}
