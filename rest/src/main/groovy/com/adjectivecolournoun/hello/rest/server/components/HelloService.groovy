package com.adjectivecolournoun.hello.rest.server.components

import com.adjectivecolournoun.hello.rest.server.dto.HelloRequest
import com.adjectivecolournoun.hello.rest.server.dto.HelloResponse
import org.springframework.stereotype.Service

@Service
class HelloService {
    HelloResponse replyTo(HelloRequest request) {
        def message = "Hello $request.name!"
        if (request.day) {
            message += " It is $request.day"
        }

        new HelloResponse(message)
    }
}
