package com.example.demo

import com.example.demo.exservice.TestService
import org.elasticsearch.action.index.IndexRequest
import org.elasticsearch.action.search.SearchRequest
import org.elasticsearch.client.RequestOptions
import org.elasticsearch.client.RestHighLevelClient
import org.elasticsearch.common.xcontent.XContentType
import org.elasticsearch.index.query.QueryBuilders
import org.elasticsearch.search.builder.SearchSourceBuilder
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import javax.annotation.Resource


@SpringBootTest
class DemoApplicationTests {

    @Resource
    lateinit var ex: TestService

    @Test
    fun contextLoads() {
        val data = com.example.demo.exservice.Test(1, "001", "一号")
        val d = ex.save(data)
        print(d)
    }

    @Test
    fun testEsGet() {
        val d = ex.findByName("2")
        print(d)
    }

}