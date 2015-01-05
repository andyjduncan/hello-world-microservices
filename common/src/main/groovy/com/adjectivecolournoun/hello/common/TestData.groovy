package com.adjectivecolournoun.hello.common

class TestData {

    static final Set names = ['You', 'Me', 'World', 'Everyone', 'John', 'Paul', 'George', 'Ringo']

    static final Set days = ['Sunday', 'Monday', 'Happy days', 'Tuesday', 'Wednesday', 'Happy days', 'Thursday', 'Friday', 'The weekend', 'Everyday', 'End of times']

    static final Set expectations = new HashSet()

    static {
        [names, days].eachCombination {
            expectations << "Hello ${it[0]}! It is ${it[1]}".toString()
        }
    }
}
