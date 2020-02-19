package com.example.demo

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@MapperScan("com.example.demo.mapper")
@RestController
class DemoApplication {
    @GetMapping
    fun home(): String {
        return "欢迎来到"
    }
}

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}
