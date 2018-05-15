package com.devoteam.fr.handson.spark

import org.apache.spark.sql.SparkSession
/*

  Provide a SparkSession

 */

trait SparkSupport {

  val AppName: String

  val DeployHost: String

  val spark : SparkSession =
    SparkSession
      .builder()
      .appName(AppName)
      .config("master", DeployHost)
      .getOrCreate()

}