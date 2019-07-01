package com.localtube

import java.io.File

import com.localtube.models.Constants
import com.localtube.models.FileModels.Video

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

trait FileOperations {

  val directoryAndFilesSplitter: File => (List[File], List[File]) = (dirObj: File) => dirObj.listFiles()
    .toList.partition(file => !file.isFile && !file.toString.startsWith("."))

  def checkExtension(extension: String): Boolean = Constants.FILE_FORMATS.exists(extension.endsWith)



  def printFileStructure(sourceFolder: File): Future[List[Video]] = Future {

    def printFileStructureHelper(dirList: List[File], fileList: List[File]): List[File] = {
      dirList match {
        case head :: Nil => val (a, b) = directoryAndFilesSplitter(head)
          if (a.isEmpty) {
            b ::: fileList
          } else {
            printFileStructureHelper(dirList.drop(1) ::: a, fileList ::: b)
          }
        case head :: _ :: _ =>
          val (a, b) = directoryAndFilesSplitter(head)
          if (a.isEmpty) {
            printFileStructureHelper(dirList.drop(1), fileList ::: b)
          } else {
            printFileStructureHelper(dirList.drop(1) ::: a, fileList ::: b)
          }
        case Nil =>
          fileList
      }
    }

    val (dList, fList) = directoryAndFilesSplitter(sourceFolder)

    printFileStructureHelper(dList, fList)
      .filter(file => checkExtension(file.getName))
      .map(file => Video(file.getName, 0, file.length, "mp4", "date", file.lastModified().toString, file.getAbsolutePath))
  }

}

object FileOperations extends FileOperations
