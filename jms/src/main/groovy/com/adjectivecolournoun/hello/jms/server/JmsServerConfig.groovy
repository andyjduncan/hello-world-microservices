package com.adjectivecolournoun.hello.jms.server

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = 'com.adjectivecolournoun.hello.jms.server.components')
class JmsServerConfig {
}

