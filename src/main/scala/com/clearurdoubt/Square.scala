package com.clearurdoubt

case class Square(side: Double) extends Shape {

  require(side >= 0, "side length should not be less than 0")

  override def area: Double = side * side
}

object SquareTest extends App {
  val s = Square(-5)

}