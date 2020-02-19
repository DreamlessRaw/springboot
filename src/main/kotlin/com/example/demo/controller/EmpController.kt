package com.example.demo.controller

import com.example.demo.entity.Emp
import com.example.demo.exservice.Test
import com.example.demo.exservice.TestService
import com.example.demo.mapper.EmpMapper
import org.elasticsearch.client.RestHighLevelClient
import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.core.ElasticsearchOperations
import org.springframework.data.elasticsearch.core.query.GetQuery
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.annotation.Resource


@RestController
@RequestMapping("emp")
class EmpController {
    @Resource
    lateinit var redisTemplate: RedisTemplate<String, String>

    @Resource
    lateinit var empMapper: EmpMapper

    @Resource
    lateinit var service: TestService

    @GetMapping("list")
    fun list(): List<Emp> {
        return empMapper.selectList(null)
    }

    @PostMapping("add")
    fun add(@RequestBody emp: Emp): Int {
        return empMapper.insert(emp)
    }

    @PostMapping("update")
    fun update(@RequestBody emp: Emp): Int {
        return empMapper.updateById(emp)
    }

    @PostMapping("del")
    fun del(@RequestBody emp: Emp): Int {
        return empMapper.deleteById(emp.id)
    }

    @PostMapping("get/{key}")
    fun get(@PathVariable key: String): String {
        return redisTemplate.opsForValue().get(key).toString()
    }

    @PostMapping("set/{key}/{value}")
    fun set(@PathVariable key: String, @PathVariable value: String): String {
        redisTemplate.opsForValue().set(key, value)
        return redisTemplate.opsForValue().get(key).toString()
    }

    @GetMapping("esget")
    fun testEsGet(): Test? {
        return service.findByName("2号")
    }

    @PostMapping("esset")
    fun esSet(@RequestBody test: Test) {
        val d = service.save(test)
        print(d)
    }

}

