package com.devoteam.fr.handson.spark



class Sparkinator() extends SparkSupport with LoggingSupport{

  def main(args: Array[String]): Unit = {

    val df = spark
      .readStream.format("kafka")
      .option("kafka.bootstrap.servers", "kafka:9092")
      .option("subscribe","connect-test")
      .load()

    df.writeStream
      .format("console")
      .option("truncate","false")
      .start()
      .awaitTermination()
  }
}