package com.example.demo.config

import org.elasticsearch.client.RestHighLevelClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.client.ClientConfiguration
import org.springframework.data.elasticsearch.client.RestClients
import javax.annotation.Resource

/**
 * 使用es环境版本一定要和springboot对应上
 * 1：查看自己项目内的libraries
 * 2: 官方参照地址：https://docs.spring.io/spring-data/elasticsearch/docs/3.2.4.RELEASE/reference/html/#preface.versions
 */
@Configuration
class ElasticsearchConfig {

    @Resource
    lateinit var appConfig: AppConfig

    @Bean
    fun restClient(): RestHighLevelClient {
        val clientConfiguration = ClientConfiguration.builder()
                .connectedTo(appConfig.esHost)
                .build()
        return RestClients.create(clientConfiguration).rest()
    }
}
