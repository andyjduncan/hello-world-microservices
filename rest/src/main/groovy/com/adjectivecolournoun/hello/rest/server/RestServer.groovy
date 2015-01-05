package com.adjectivecolournoun.hello.rest.server

import org.springframework.boot.SpringApplication

def context = SpringApplication.run(RestConfig, args)

println 'Return to end'

System.in.read()

SpringApplication.exit(context)