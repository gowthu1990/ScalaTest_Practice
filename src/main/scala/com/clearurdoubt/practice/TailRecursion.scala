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

    concat("", params: _*)
  }

  def factorial(n: Int): Long = {
    @tailrec
    def factorial(n: Int, acc: Long): Long = {
      if(n <= 0) acc
      else factorial(n-1, acc * n)
    }

    // factorial(5, 1)
    // factorial(4, 1 * 5)
    // factorial(3, 1 * 5 * 4)
    // factorial(2, 1 * 5 * 4 * 3)
    // factorial(1, 1 * 5 * 4 * 2)
    // factorial(0, 1 * 5 * 4 * 2 * 1) => 120

    // n * n - 1 * n - 2 .... * n - n
    factorial(n, acc=1)
  }
}
