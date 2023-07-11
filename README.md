<h1 align="center"> kafka-consumer</h1>
<h1 align="center">

![Static Badge](https://img.shields.io/badge/java-11-blue)
![Static Badge](https://img.shields.io/badge/Springboot-2.7.13-blue)
![Static Badge](https://img.shields.io/badge/Gradle-8.1.1-blue)

</h1>

Building a kafka consumer to handle multiple requests

It contains a kafka listener and a handler class to receive multiple requests handling them and mapping each type with their corresponding message.

## Requirements

1. Kafka installed (check [How to run Kafka](#how-to-run-kafka))
2. JDK 11

## How to run Kafka

It is needed to set zookeper service and kafka broker before calling
the kafka consumer and producer

In order to do that, you should download kafka from https://www.apache.org/dyn/closer.cgi?path=/kafka/3.5.0/kafka_2.13-3.5.0.tgz

Then, you can now move to folder and execute the following set up scripts (they will need to keep running while you are using your application):
```bash
# Start the ZooKeeper service
$ bin/zookeeper-server-start.sh config/zookeeper.properties
```

```bash
# Start the Kafka broker service
$ bin/kafka-server-start.sh config/server.properties
```

Next step, you need to create a kafka topic. Specifically for this code I am using the topic financial-demo.

```bash
$ bin/kafka-topics.sh --create --topic financial-demo --bootstrap-server localhost:9092
```

Now to produce event messages, you will need to initialize the kafka producer script and start typing the messages and hit enter to send it:

```bash
$ bin/kafka-console-producer.sh --topic financial-demo --bootstrap-server localhost:9092
```

And to listen the data sent, you can retrieve all data and continue listening using the following command:

```bash
$ bin/kafka-console-consumer.sh --topic financial-demo --from-beginning --bootstrap-server localhost:9092
```