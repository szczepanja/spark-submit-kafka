# spark-submit-kafka

## Exercise

Write [spark structured streaming](https://spark.apache.org/docs/3.2.1/structured-streaming-kafka-integration.html) application that will:

- run on command line _(spark-submit)_ 
- read records from topic (args(0) - from kafka to console)
- write it down the screen


1. Run zookeeper:

````
    bin/zookeeper-server-start.sh config/zookeeper.properties
````

2. Run kafka server:

````
    bin/kafka-server-start.sh config/server.properties
````

3. Run kafka console producer:

````
    bin/kafka-console-producer.sh --topic <topic-name> --bootstrap-server :9092
````

4. Run spark server: 

````
    bin/spark-submit --packages org.apache.spark:spark-sql-kafka-0-10_2.12:3.2.1 <path/to/project.jar>
````

Write messages from _kafka producer_ console and watch displayed data frame in _spark server_ console. Enjoy!
