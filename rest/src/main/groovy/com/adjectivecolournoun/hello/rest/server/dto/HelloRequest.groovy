package com.adjectivecolournoun.hello.rest.server.dto

import groovy.transform.Canonical
import groovy.transform.Immutable

@Canonical
class HelloRequest {

    String name

    String day
}
