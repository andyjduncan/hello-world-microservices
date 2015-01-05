package com.adjectivecolournoun.hello.protobuf.client

import com.adjectivecolournoun.hello.common.TestData
import com.adjectivecolournoun.hello.protobuf.Hello

import javax.websocket.ContainerProvider
import javax.websocket.Session
import java.nio.ByteBuffer
import java.util.concurrent.TimeUnit

println 'Warming'

1000.times { // Warm up JIT
    def handler = new HelloClientHandler(expectations: TestData.expectations.toSet())

    def session = openSession(handler)

    sendRequests(session)

    if (!handler.done.await(5, TimeUnit.MINUTES)) {
        println 'Timeout expired'
        System.exit(1)
    }

    session.close()
}

println 'Testing'

long start = System.currentTimeMillis()

1000.times {
    def handler = new HelloClientHandler(expectations: TestData.expectations.toSet())

    def session = openSession(handler)

    sendRequests(session)

    if (!handler.done.await(5, TimeUnit.MINUTES)) {
        println 'Timeout expired'
        System.exit(1)
    }

    session.close()
}

println "Took ${System.currentTimeMillis() - start}ms"

private openSession(HelloClientHandler handler) {
    def container = ContainerProvider.webSocketContainer
    container.connectToServer(handler, new URI('ws://localhost:8080/hello'))
}

private sendRequests(Session session) {

    def remote = session.basicRemote

    TestData.names.each { who ->
        TestData.days.each { when ->
            def request = Hello.HelloRequest.newBuilder().setName(who).setDay(when).build()

            def message = ByteBuffer.wrap(request.toByteArray())

            remote.sendBinary(message)
        }
    }
}
