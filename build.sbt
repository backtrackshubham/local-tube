name := "local-tube"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
  "log4j" % "log4j" % "1.2.17",
  "com.typesafe.akka" %% "akka-http" % "10.1.8",
  "com.typesafe.akka" %% "akka-http-testkit" % "10.1.8" % Test,
  "com.typesafe.akka" %% "akka-actor" % "2.5.22",
  "com.google.code.gson" % "gson" % "2.8.5"
)
