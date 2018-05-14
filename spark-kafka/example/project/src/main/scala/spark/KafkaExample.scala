package org.hands.on.spark

import org.apache.spark.sql.SparkSession
import org.apache.spark.SparkConf
import org.apache.spark.sql.functions._
import org.apache.spark.sql._
import org.apache.spark.sql.types._
import org.spark.implicits._

/** Main class */
object KafkaExample {





  val spark : SparkSession =
    SparkSession
      .builder()
      .appName("")
      .config("spark.master", "spark://master:7077")
      .getOrCreate()

  /** Main function */
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
