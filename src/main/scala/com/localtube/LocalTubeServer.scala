package com.localtube

import java.io.File

import com.localtube.utils.LoggerUtil

import scala.concurrent.ExecutionContext.Implicits.global


object LocalTubeServer extends App with LoggerUtil{

  val file = new File("/home/freaks/SHUBHAM/Tuts/Akka")


  FileOperations.printFileStructure(file).map(println)


  Thread.sleep(100000)


}
