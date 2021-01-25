package com.clearurdoubt

import org.scalatest
import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.matchers.should.Matchers

object SquareSpec extends AnyFeatureSpec with Matchers {

  println("Starting: ")

  Scenario("A Square should fail if the side length is negative") {
    assertThrows[java.lang.IllegalArgumentException] {
      Square(-5)
    }
  }

  Scenario("Correct Square area needs to be returned") {
    val square = Square(5.0)
    assert(square.area == 25.0)
  }
}
