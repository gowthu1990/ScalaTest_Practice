package com.clearurdoubt

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

object SquareTests extends AnyFlatSpec with Matchers {

  "A Square" should "fail if the side length is negative" in {
    assertThrows[java.lang.IllegalArgumentException] {
      Square(-5)
    }
  }

  it should "return area correctly" in {
    val square = Square(5.0)

    assert(square.area == 25.0)
  }
}
