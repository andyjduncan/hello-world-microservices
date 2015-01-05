package com.adjectivecolournoun.hello.protobuf.client

import com.adjectivecolournoun.hello.protobuf.Hello.HelloResponse

import javax.websocket.ClientEndpoint
import javax.websocket.OnMessage
import java.util.concurrent.CountDownLatch

@ClientEndpoint
class HelloClientHandler {

    Set expectations

    CountDownLatch done = new CountDownLatch(1)

    @OnMessage
    void onMessage(byte[] message) {
        def response = HelloResponse.parseFrom(message)

        expectations.remove response.message

        if (!expectations) {
            done.countDown()
        }
    }
}
