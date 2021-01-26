package com.clearurdoubt

case class CamelCaseWordMaker() {
  def capitalize(input: Array[String]): Array[String] =
    input.map(str => str.split(" "))
      .map(arr => arr.map(_.capitalize).mkString(" "))
}