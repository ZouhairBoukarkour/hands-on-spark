package com.devoteam.fr.handson.spark

import org.slf4j.LoggerFactory

/*
  Provide a SparkSession
 */

trait LoggingSupport {

  val logger = LoggerFactory.getLogger(this.getClass.getName)

}