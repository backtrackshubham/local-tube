package com.localtube.models

object FileModels {
  case class Video(name: String,
                   duration: Long,
                   size: Long,
                   format: String,
                   createdDate: String,
                   modifiedDate: String,
                   path: String)
}
