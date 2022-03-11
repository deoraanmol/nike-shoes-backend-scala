package com.shoes.nikebackend

import io.circe.Json
import org.http4s._
import org.http4s.circe._
import org.http4s.server._
import org.http4s.dsl._
import sttp.client3
import sttp.client3.{HttpURLConnectionBackend, UriContext, basicRequest}

object FetchShoeData {
  val service = HttpService {
    case GET -> Root / "api" / "shoe-price" / shoeId =>
      val request = basicRequest.get(
        uri"https://bi8cxjuyll.execute-api.us-west-2.amazonaws.com/prices/shoes?id=$shoeId")
      val backend = HttpURLConnectionBackend()
      val response = request.send(backend)
      val text = response.body.right.get
      Ok(Json.fromString(text), Headers(Header("Access-Control-Allow-Origin", "*")))
  }
}
