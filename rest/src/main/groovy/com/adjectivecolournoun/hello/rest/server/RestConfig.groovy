package com.adjectivecolournoun.hello.rest.server

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@Configuration
@EnableAutoConfiguration
@EnableWebMvc
@ComponentScan('com.adjectivecolournoun.hello.rest.server.components')
@Import(EmbeddedServletContainerAutoConfiguration)
class RestConfig {
}
