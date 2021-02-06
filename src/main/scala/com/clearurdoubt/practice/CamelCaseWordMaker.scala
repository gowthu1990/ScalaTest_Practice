package com.clearurdoubt.practice

case class CamelCaseWordMaker() {
  def capitalize(input: Array[String]): Array[String] =
    input.map(str => str.split(" "))
      .map(arr => arr.map(_.capitalize).mkString(" "))
}

object CamelCaseWordMaker extends App {
  def capitalize(input: List[String]): List[String] =
    input
      .map(str => str.split(" "))
      .map(arr => arr.map(_.capitalize).mkString(" "))

  println(capitalize(List("hello", "world", "hello world")))
}