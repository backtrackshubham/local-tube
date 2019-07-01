package com.localtube.utils

import java.io.File

import com.localtube.models.FileModels.Video

import scala.concurrent.Future


trait FileUtils extends LoggerUtil {
  def findAllVideosAsync(directory: String): Future[List[Video]] = ???

  def findAllVideos(directory: String): List[Video] = {
    val file = new File(directory)

    if (!file.exists) {
      errorMessage(s"$directory path doesn't exist")
      List.empty[Video]
    } else if (file.isFile) {
      errorMessage(s"path is a file")
      List.empty[Video]
    } else {
      List.empty[Video]
    }
  }

  def traverseDirectory(directory: String): List[Video] = ???
}

object FileUtils extends FileUtils
