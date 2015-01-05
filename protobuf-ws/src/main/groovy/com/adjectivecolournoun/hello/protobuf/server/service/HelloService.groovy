package com.adjectivecolournoun.hello.protobuf.server.service

import com.adjectivecolournoun.hello.protobuf.Hello.HelloRequest
import com.adjectivecolournoun.hello.protobuf.Hello.HelloResponse
import org.springframework.stereotype.Service

@Service
class HelloService {
    HelloResponse replyTo(HelloRequest request) {
        def message = "Hello $request.name!"
        if (request.hasDay()) {
            message += " It is $request.day"
        }

        HelloResponse.newBuilder().setMessage(message).build()
    }
}
