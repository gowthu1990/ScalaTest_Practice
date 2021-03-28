package com.clearurdoubt.sorting

object Sort {
   def bubbleSort(input: Array[Int]): Unit =
    for {
      i <- 1 until input.length
      j <- 0 until (input.length - i)
      if input(j) > input(j + 1)
    } {
        val x = input(j)
        input(j) = input(j + 1)
        input(j + 1) = x
    }
}