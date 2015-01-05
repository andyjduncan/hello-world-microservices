package com.adjectivecolournoun.hello.protobuf.server

import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration
import org.springframework.boot.autoconfigure.websocket.WebSocketAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.web.socket.server.standard.ServerEndpointExporter

import javax.websocket.server.ServerEndpointConfig.Configurator

@Configuration
@ComponentScan(basePackages = 'com.adjectivecolournoun.hello.protobuf.server.service')
@Import([EmbeddedServletContainerAutoConfiguration, WebSocketAutoConfiguration])
class HelloConfig {

    @Bean
    HelloEndpoint helloEndpoint() {
        new HelloEndpoint()
    }

    @Bean
    ServerEndpointExporter endpointExporter() {
        new ServerEndpointExporter()
    }

    @Bean
    Configurator configurator() {
        new StaticContextConfigurator()
    }
}
