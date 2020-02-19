package com.example.demo.controller

import com.example.demo.exservice.Test
import com.example.demo.exservice.TestService
import org.springframework.web.bind.annotation.*
import javax.annotation.Resource


@RestController
@RequestMapping("es")
class EsController {
    @Resource
    lateinit var service: TestService

    @GetMapping("get/{name}")
    fun get(@PathVariable name: String): Test? {
        return service.findByName(name)
    }

    @PostMapping("set")
    fun set(@RequestBody test: Test) {
        service.save(test)
    }
}