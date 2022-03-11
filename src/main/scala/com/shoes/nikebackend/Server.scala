package com.shoes.nikebackend

import scala.util.Properties.envOrNone
import org.http4s.server.blaze.BlazeBuilder
import org.http4s.util.ProcessApp
import scalaz.concurrent.Task
import scalaz.stream.Process

object Server extends ProcessApp {
  val port: Int = envOrNone("HTTP_PORT").fold(8081)(_.toInt)

  def process(args: List[String]): Process[Task, Nothing] = BlazeBuilder.bindHttp(port)
    .mountService(FetchShoeData.service, "/")
    .serve
}
