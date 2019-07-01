package com.localtube.utils

import org.apache.log4j.Logger

trait LoggerUtil {

  val logger: Logger = Logger.getLogger(getClass.getName)

  def info(message: String): Unit = logger.info(message)

  def error(message: String, exception: Throwable): Unit = logger.error(message + " Reason::" + exception.printStackTrace())

  def errorMessage(message: String): Unit = logger.error(message)

}

object LoggerUtil extends LoggerUtil
