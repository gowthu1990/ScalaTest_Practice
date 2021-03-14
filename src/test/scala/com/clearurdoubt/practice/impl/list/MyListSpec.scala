package com.clearurdoubt.practice.impl.list

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class MyListSpec extends AnyFlatSpec with Matchers {
  "isEmpty" should "return true when invoked on an EmptyList" in {
    EmptyList.isEmpty shouldBe true
  }

  it should "return false when invoked on a NonEmptyList" in {
    val myList = MyList(1, 2, 3)

    myList.isEmpty shouldBe false
  }

  "+" should "return a new NonEmptyList by adding the given element to the EmptyList" in {
    (EmptyList + 3) shouldBe MyList(3)
  }

  it should "return another NonEmptyList by adding the given element to the given NonEmptyList" in {
    val myList = MyList(1, 2, 3)

    (myList + 4) shouldBe MyList(4, 1, 2, 3)
  }
}
