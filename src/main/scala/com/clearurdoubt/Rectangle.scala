package com.clearurdoubt

case class Rectangle(length: Double, width: Double) extends Shape {
  override def area: Double = length * width
}
