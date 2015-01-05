package com.adjectivecolournoun.hello.jms.server.components

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jms.annotation.JmsListener
import org.springframework.jms.core.JmsTemplate
import org.springframework.messaging.handler.annotation.Header
import org.springframework.stereotype.Component

@Component
class JmsServerReceiver {

    @JmsListener(destination = 'hello')
    String sayHello(String name, @Header('day') String day) {
        def message = "Hello $name!"
        if (day) {
            message += " It is $day"
        }

        message
    }
}
