package com.clearurdoubt.practice

import scala.annotation.tailrec

class TailRecursion {
  def concat(delimiter: String, params: String*): String = {
    @tailrec
    def concat(acc: String, params: String*): String = {
      if(params.isEmpty) ""
      else if(params.length == 1) acc + params.head
      else concat(acc + params.head + delimiter, params.tail: _*)
    }

    concat(acc = ":", params: _*)
  }

  def factorial(n: Int): Long = {
    @tailrec
    def factorial(n: Int, acc: Long): Long = {
      if(n <= 0) acc
      else factorial(n-1, acc * n)
    }

    factorial(n, acc=1)
  }
}
