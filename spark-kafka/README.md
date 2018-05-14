### spark-kafka
this docker-compose file will provide you with a spark and a kafka cluster including the spark-streaming jars.

You will have to build our spark image using the following command :
```
docker build -t sparky:latest
```
:warning: Be sure to change the value of volume `MY_LOCAL_DIR` in order to have acorrect mapping to your host directory
