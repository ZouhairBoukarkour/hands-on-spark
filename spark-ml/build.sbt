val sparkVersion = "2.3.0"

lazy val commonSettings = Seq(
  organization := "com.devoteam.fr",
  scalaVersion := "2.11.11",
  version := "0.1.0-SNAPSHOT",
  resolvers += "bintray-spark-packages" at "https://dl.bintray.com/spark-packages/maven/",
  resolvers += "Typesafe Simple Repository" at "http://repo.typesafe.com/typesafe/simple/maven-releases/",
  resolvers += "MavenRepository" at "https://mvnrepository.com/",
  libraryDependencies ++=
    "org.slf4j" % "slf4j-api" % "1.7.5" ::
    "org.slf4j" % "slf4j-simple" % "1.7.5" :: Nil
)

lazy val root = project.in(file("."))
    .aggregate(spark)


lazy val spark = project.in(file("spark"))
  .settings(commonSettings: _*)
  .settings(parallelExecution:= false)
  .settings(
    libraryDependencies ++=
      "org.apache.spark" %% "spark-core" % sparkVersion ::
        "org.apache.spark" %% "spark-streaming" % sparkVersion ::
        "org.apache.spark" %% "spark-sql" % sparkVersion ::
        "org.apache.spark" %% "spark-streaming-kafka-0-10" % sparkVersion ::
        "org.apache.spark" %% "spark-mllib" % sparkVersion :: Nil
  )