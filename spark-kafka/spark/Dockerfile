FROM ubuntu

# Environment
ENV SPARK_VERSION 2.2.3
ENV HADOOP_VERSION 2.7
ENV SCALA_VERSION 2.11
ENV SPARK_HOME /usr/local/spark

# wget
RUN apt-get -y update && apt-get install -y wget


# Java
RUN apt-get install -y --no-install-recommends openjdk-8-jre-headless

# Spark
RUN cd /tmp && \
    wget http://apache.crihan.fr/dist/spark/spark-2.3.0/spark-2.3.0-bin-hadoop2.7.tgz && \
    tar -xvzf spark-2.3.0-bin-hadoop2.7.tgz -C /usr/local && \
    rm spark-2.3.0-bin-hadoop2.7.tgz

RUN cd /usr/local && ln -s spark-2.3.0-bin-hadoop2.7.tgz spark

EXPOSE 8080

EXPOSE 6066

EXPOSE 7077
