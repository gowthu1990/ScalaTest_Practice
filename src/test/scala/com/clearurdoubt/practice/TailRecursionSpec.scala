package com.clearurdoubt.practice

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class TailRecursionSpec extends AnyFlatSpec with Matchers {
  val tr = new TailRecursion

  "concat" should "return the concatenated string with the delimiter" in {
    // No Strings
    tr.concat("-") shouldBe ""

    // One Parameter
    tr.concat("-", "Hello") shouldBe "Hello"

    // Two Parameters
    tr.concat("-", "Hello", "World", "of", "Scala") shouldBe "Hello-World-of-Scala"
  }

  "factorial" should "return the factorial of the given number" in {
    // 0 factorial
    tr.factorial(0) shouldBe 1

    // 5 factorial
    tr.factorial shouldBe 120
  }
}
