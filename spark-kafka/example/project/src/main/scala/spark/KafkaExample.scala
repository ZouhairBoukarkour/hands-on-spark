package org.hands.on.spark

import org.apache.spark.SparkContext
import org.apache.spark.sql._
import org.apache.spark.sql.types._

/** Main class */
object KafkaExample {

  import org.apache.spark.sql.SparkSession
  import org.apache.spark.SparkConf
  import org.apache.spark.sql.functions._

  import org.spark.implicits

  val spark : SparkSession =
    SparkSession
      .builder()
      .appName("")
      .config("spark.master", "local[*]")
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
