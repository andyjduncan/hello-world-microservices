package com.adjectivecolournoun.hello.jms.server

import com.adjectivecolournoun.hello.common.TestData
import org.springframework.boot.SpringApplication
import org.springframework.jms.core.JmsTemplate
import org.springframework.jms.core.MessageCreator

import javax.jms.Session
import javax.jms.TextMessage
import java.nio.ByteBuffer
import java.util.concurrent.TimeUnit

def context = SpringApplication.run(JmsServerConfig, args)

def template = context.getBean(JmsTemplate)

println 'Warming...'

1000.times {
    def handler = new JmsHandler(template: template, expectations: TestData.expectations)

    sendRequests handler

    if (!handler.done.await(5, TimeUnit.MINUTES)) {
        println 'Timeout expired'
        System.exit(1)
    }
}

println 'Testing'

long start = System.currentTimeMillis()

1000.times {
    def handler = new JmsHandler(template: template, expectations: TestData.expectations)

    sendRequests handler

    if (!handler.done.await(5, TimeUnit.MINUTES)) {
        println 'Timeout expired'
        System.exit(1)
    }
}

println "Took ${System.currentTimeMillis() - start}ms"

SpringApplication.exit(context)

private sendRequests(JmsHandler handler) {
    TestData.names.each { who ->
        TestData.days.each { when ->
            handler.handle who, when
        }
    }
}