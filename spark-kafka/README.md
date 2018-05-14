### spark-kafka
this docker-compose file will provide you with a spark and a kafka cluster including the spark-streaming jars.

You will have to build our spark image using the following command :
```
docker build -t sparky:latest
```

Now, you will have to split your data set in multiple pieces of 100 lines using
```
split -l 100 Andriod_2k.log
```

launch a **docker-compose** and pray.

:warning: Be sure to change the value of volume `MY_LOCAL_DIR` in order to have acorrect mapping to your host directory

Now open a bash interfcae into the **kafka container** and run the following

```shell
cat ~/data/<ONE OF YOUR DATA CHUNK FILES> > test.txt
connect-standalone.sh $KAFKA_HOME/config/connect-standalone.properties $KAFKA_HOME/config/connect-file-source.properties $KAFKA_HOME/config/connect-file-sink.properties
```
As your doing this, run a kafka-console-consumer on the **connect-test** topic using

```shell
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic connect-test --from-beginning
```
You should see every line as a seperated event

Now you can append new data to the topic using a simple command
```
cat <ANOTHER_CHUNK> >> test.txt
```

Then using the spark application example, package a spark application and deploy it from the spark master container using

```shell
cd $SPARK_HOME
./bin/spark-submit --packages org.apache.spark:spark-sql-kafka-0-10_2.11:2.0.2 <MON_PACKAGE>
```

The additionnal jar ```--packages org.apache.spark:spark-sql-kafka-0-10_2.11:2.0.2``` is provided in the [jars directory in example](example/jars)
