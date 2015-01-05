package com.adjectivecolournoun.hello.protobuf.server

import com.adjectivecolournoun.hello.protobuf.Hello.HelloRequest
import com.adjectivecolournoun.hello.protobuf.Hello.HelloResponse
import com.adjectivecolournoun.hello.protobuf.server.service.HelloService
import org.springframework.beans.factory.annotation.Autowired

import javax.websocket.OnMessage
import javax.websocket.server.ServerEndpoint

@ServerEndpoint(
        value = '/hello',
        configurator = StaticContextConfigurator,
        decoders = HelloRequestDecoder,
        encoders = HelloResponseEncoder
)
class HelloEndpoint {

    @Autowired
    HelloService helloService

    @OnMessage
    HelloResponse handleMessage(HelloRequest request) {
        helloService.replyTo request
    }
}