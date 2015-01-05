package com.adjectivecolournoun.hello.protobuf.server

import com.adjectivecolournoun.hello.protobuf.Hello.HelloRequest
import com.google.protobuf.InvalidProtocolBufferException

import javax.websocket.DecodeException
import javax.websocket.Decoder
import javax.websocket.EndpointConfig
import java.nio.ByteBuffer

class HelloRequestDecoder implements Decoder.Binary<HelloRequest> {

    @Override
    HelloRequest decode(ByteBuffer bytes) throws DecodeException {
        try {
            decodeRequest bytes
        } catch (InvalidProtocolBufferException e) {
            throw new DecodeException(bytes, 'Invalid HelloRequest', e)
        }
    }

    @Override
    boolean willDecode(ByteBuffer bytes) {
        try {
            decodeRequest bytes
            true
        } catch (InvalidProtocolBufferException e) {
            false
        }
    }

    private decodeRequest(ByteBuffer bytes) {
        HelloRequest.parseFrom(bytes.array())
    }

    @Override
    void init(EndpointConfig endpointConfig) {
    }

    @Override
    void destroy() {
    }
}
