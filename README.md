# Hello World Microservices

Some example microservice implementations to say hello.  Each microservice takes a name and an optional day and
replies with a cheery message.
The test data and expectations can be found in ``common:com.adjectivecolournoun.hello.common.TestData``

The various test scripts provide timings but these aren't intended as comparative tests.  The different implementations
have different blocking characteristics and degrees of (a)synchronicity.  They're just simple proofs of concept to
try out the alternative service implementations.  All of the examples use [Spring Boot] [boot].

## JMS
The ``jms`` module uses Spring JMS annotations to consume and reply with text messages.  The sent message can have the
``day`` header set to send the day value.  The sending and receiving is synchronous.

There is only one script to run, ``com/adjectivecolournoun/hello/jms/server/JmsServer.groovy``

## Websockets with Protocol Buffers
The ``protobuf-ws`` module uses [Google Protocol Buffers] [protobuf] and [JSR 356] [jsr356] annotated endpoints.  Sending and
receiving is asynchronous.

To compile the .proto messages, set the ``protobufCompiler`` property in ``~/.gradle/gradle.properties`` to the full
path to ``protoc`` on your system.

There are two components to run: the server ``com/adjectivecolournoun/hello/protobuf/server/WebsocketServer.groovy``
and the client ``com/adjectivecolournoun/hello/protobuf/client/WebsocketClient.groovy``

## REST
The ``rest`` module uses a [Spring MVC] [mvc] ``RestController`` with implicit binding to DTOs.  Sending and receiving
is synchronous.

There are two components to run: the server ``com/adjectivecolournoun/hello/rest/server/RestServer.groovy``
and the client ``com/adjectivecolournoun/hello/rest/client/RestClient.groovy``

[boot]: http://projects.spring.io/spring-boot/
[protobuf]: https://developers.google.com/protocol-buffers/
[jsr356]: http://www.oracle.com/technetwork/articles/java/jsr356-1937161.html
[mvc]: http://docs.spring.io/spring/docs/current/spring-framework-reference/html/spring-web.html