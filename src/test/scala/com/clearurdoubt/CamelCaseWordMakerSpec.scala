package com.clearurdoubt

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CamelCaseWordMakerSpec extends AnyFlatSpec with Matchers {
  "A CamelCaseWordMaker" should "make first character of each word uppercase" in {
    val strArray = Array("hello", "world", "happy world")

    val output:Array[String] = CamelCaseWordMaker().capitalize(strArray)

    output should be (Array("Hello", "World", "Happy World"))
  }
}
