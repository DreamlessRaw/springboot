package com.example.demo.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component


@Component
@ConfigurationProperties("app")
class AppConfig {
    var esHost: String = ""
    var redisHost: String = ""
}