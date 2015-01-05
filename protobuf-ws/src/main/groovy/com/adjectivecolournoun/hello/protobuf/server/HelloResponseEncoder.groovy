package com.adjectivecolournoun.hello.protobuf.server

import com.adjectivecolournoun.hello.protobuf.Hello.HelloResponse

import javax.websocket.EncodeException
import javax.websocket.Encoder
import javax.websocket.EndpointConfig
import java.nio.ByteBuffer

class HelloResponseEncoder implements Encoder.Binary<HelloResponse> {

    @Override
    ByteBuffer encode(HelloResponse response) throws EncodeException {
        ByteBuffer.wrap response.toByteArray()
    }

    @Override
    void init(EndpointConfig endpointConfig) {
    }

    @Override
    void destroy() {
    }
}
