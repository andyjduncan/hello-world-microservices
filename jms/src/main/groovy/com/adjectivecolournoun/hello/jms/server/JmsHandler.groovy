package com.adjectivecolournoun.hello.jms.server

import org.springframework.jms.core.JmsTemplate
import org.springframework.jms.core.MessageCreator

import javax.jms.Session
import javax.jms.TextMessage
import java.util.concurrent.CountDownLatch

class JmsHandler {

    JmsTemplate template

    Set expectations

    CountDownLatch done = new CountDownLatch(1)

    void handle(String name, String day) {

        TextMessage reply = template.sendAndReceive('hello', { Session session ->
            def message = session.createTextMessage(name)
            message.setStringProperty 'day', day
            message
        } as MessageCreator)


        expectations.remove reply.text

        if (!expectations) {
            done.countDown()
        }
    }
}
