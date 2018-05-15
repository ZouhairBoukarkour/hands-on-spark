package com.devoteam.fr.handson.spark

import org.apache.spark.sql.Row
import org.apache.spark.sql.types._


class SparkMlExample() extends SparkSupport with LoggingSupport{

  val AppName : String = "MyApp"

  val DeployHost : String = "local[*]"

  def main(args: Array[String]): Unit = {

    // Now you have a SparkSession accessible using "spark"

    val raw = spark.sparkContext.textFile("spark-ml/src/main/resources/Android_2K.log")

    val schema = StructType(Seq(
        StructField("Date", StringType),
        StructField("Time", TimestampType),
        StructField("Pid_1", StringType),
        StructField("Pid_2", StringType),
        StructField("Label", StringType),
        StructField("Service", StringType),
        StructField("Description", StringType)
      )
    )

    val splitted = raw.map( lines => {
      val ( keys: String, desc: String ) = lines.split("[a-Z]+: ")
      Row(keys.split(" ").flatMap(_),desc)
    })

    spark.createDataFrame(splitted,schema)




  }

}
