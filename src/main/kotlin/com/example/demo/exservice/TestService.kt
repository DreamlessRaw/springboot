package com.example.demo.exservice

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository

@Document(indexName = "es", type = "Test")
class Test {

    @Id
    var id = 0
    var code: String = ""
    var name: String = ""

    constructor()
    constructor(id: Int, code: String, name: String) {
        this.id = id
        this.code = code
        this.name = name
    }
}


interface TestService : ElasticsearchRepository<Test, Int> {
    /**
     * 参数和方法对照
     * https://docs.spring.io/spring-data/elasticsearch/docs/3.2.4.RELEASE/reference/html/#elasticsearch.query-methods.criterions
     */
    fun findByName(name: String): Test?
}