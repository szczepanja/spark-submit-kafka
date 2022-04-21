# spark-submit-kafka

## Exercise

Write [spark structured streaming](https://spark.apache.org/docs/3.2.1/structured-streaming-kafka-integration.html) application that will:

- run on command line _(spark-submit)_ 
- read records from topic (args(0) - from kafka to console)
- write it down the screen



1. Run zookeeper:

````
    bin\windows>zookeeper-server-start.bat C:kafka\config\zookeeper.properties
````

2. Run kafka server:

````
    bin\windows>kafka-server-start.bat C:\kafka\config\server.properties
````

3. Run spark server: 

````
    bin\spark-submit --packages org.apache.spark:spark-sql-kafka-0-10_2.12:3.2.1
````