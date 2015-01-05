package com.adjectivecolournoun.hello.protobuf.server

import org.springframework.boot.SpringApplication

def context = SpringApplication.run(HelloConfig, args)

println 'Return to end'

System.in.read()

SpringApplication.exit context