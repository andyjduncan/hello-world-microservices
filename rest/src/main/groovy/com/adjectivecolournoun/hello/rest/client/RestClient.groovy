package com.adjectivecolournoun.hello.rest.client

import com.adjectivecolournoun.hello.rest.server.dto.HelloResponse
import org.springframework.web.client.RestTemplate

import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

import static com.adjectivecolournoun.hello.common.TestData.*

template = new RestTemplate()

println 'Warming'

1000.times {
    def handler = new RestHandler(expectations: expectations.toSet())

    sendRequests(handler)

    if (!handler.done.await(5, TimeUnit.MINUTES)) {
        println 'Timeout expired'
        System.exit(1)
    }
}


println 'Testing'

long start = System.currentTimeMillis()

1000.times {
    def handler = new RestHandler(expectations: expectations.toSet())

    sendRequests(handler)

    if (!handler.done.await(5, TimeUnit.MINUTES)) {
        println 'Timeout expired'
        System.exit(1)
    }
}

println "Took ${System.currentTimeMillis() - start}ms"

private sendRequests(handler) {
    names.each { name ->
        days.each { day ->
            def uri = new URI('http', 'localhost:8080', "/hello/$name", "day=$day", null)
            def response = template.getForEntity(uri, HelloResponse)
            handler.handleResponse response.body
        }
    }
}

class RestHandler {

    Set expectations

    CountDownLatch done = new CountDownLatch(1)

    void handleResponse(HelloResponse response) {
        expectations.remove response.message

        if (expectations.size() < 1) {
            done.countDown()
        }
    }
}