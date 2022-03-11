package com.shoes.nikebackend

import org.http4s.dsl._
import org.http4s.{Method, Request, Response, Status}
import org.specs2.matcher.MatchResult

class FetchShoeDataSpec extends org.specs2.mutable.Specification {
  "FetchShoeData" >> {
    "return 200" >> {
      uriReturns200()
    }
    "return hello world" >> {
      uriReturnsFetchShoeData()
    }
  }

  private[this] val retFetchShoeData: Response = {
    val getHW = Request(Method.GET, uri("/hello/world"))
    val task = FetchShoeData.service.orNotFound(getHW)
    task.unsafePerformSync
  }

  private[this] def uriReturns200(): MatchResult[Status] =
    retFetchShoeData.status must beEqualTo(Status.Ok)

  private[this] def uriReturnsFetchShoeData(): MatchResult[String] =
    retFetchShoeData.as[String].unsafePerformSync must beEqualTo("{\"message\":\"Hello, world\"}")
}
