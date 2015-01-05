package com.adjectivecolournoun.hello.rest.server.components

import com.adjectivecolournoun.hello.rest.server.dto.HelloRequest
import com.adjectivecolournoun.hello.rest.server.dto.HelloResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @Autowired
    HelloService helloService

    @RequestMapping(value = '/hello/{name}', method = RequestMethod.GET)
    HelloResponse hello(HelloRequest request) {
        helloService.replyTo request
    }
}
