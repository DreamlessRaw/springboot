package com.example.demo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer

@Configuration
class RedisConfig {
    @Bean
    @SuppressWarnings("all")
    fun redisTemplate(factory: RedisConnectionFactory): RedisTemplate<String, Any> {
        val template = RedisTemplate<String, Any>()

        template.setConnectionFactory(factory)

        val stringRedisSerializer = StringRedisSerializer()

        // key采用String的序列化方式

        template.keySerializer = stringRedisSerializer

        // hash的key也采用String的序列化方式

        template.hashKeySerializer = stringRedisSerializer

        // value序列化方式采用jackson

        template.valueSerializer = GenericJackson2JsonRedisSerializer()

        // hash的value序列化方式采用jackson
        template.hashValueSerializer = GenericJackson2JsonRedisSerializer()

        template.afterPropertiesSet()

        return template
    }
}